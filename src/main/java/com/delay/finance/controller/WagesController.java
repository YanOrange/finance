package com.delay.finance.controller;

import com.delay.finance.entity.Company;
import com.delay.finance.entity.IORecord;
import com.delay.finance.entity.User;
import com.delay.finance.entity.Wages;
import com.delay.finance.repository.CompanyRepository;
import com.delay.finance.service.IORecordService;
import com.delay.finance.service.UserService;
import com.delay.finance.service.WagesService;
import com.delay.finance.utils.ExecuteResult;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:26
 */
@Controller
@RequestMapping("wages")
public class WagesController extends BaseController{

    @Autowired
    WagesService wagesService;
    @Autowired
    UserService userService;
    @Autowired
    IORecordService ioRecordService;
    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("findWagesByUser")
    @ResponseBody
    public ExecuteResult findWagesByUser(){
        Integer userId = getUser().getId();

        List<Wages> list = wagesService.findByUserId(userId);

        return ExecuteResult.ok(list);

    }


    /**
     * 根据月份查找工资明细
     * @return
     */
    @RequestMapping("findWagesByRemark")
    @ResponseBody
    public ExecuteResult findWagesByRemark(){
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String format = DateFormatUtils.format(time, "yyyy-MM");
        List<Wages> list = wagesService.findWagesByRemark(format);

        return ExecuteResult.ok(list);

    }

    /**
     * 生成工资条
     * @return
     */
    @RequestMapping("makeWages")
    @ResponseBody
    public ExecuteResult makeWages(){

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String format = DateFormatUtils.format(time, "yyyy-MM");
        List<Wages> list = wagesService.findWagesByRemark(format);
        if(CollectionUtils.isEmpty(list)){
            List<User> userList = userService.findAll();
            userList.stream().forEach(u->{
                Wages wages = totalWages(u, format);
                wagesService.saveOrUpdate(wages);
            });
            return ExecuteResult.ok();
        }

        return ExecuteResult.fail("已生成工资条，请勿重复生成");

    }

    /**
     * 计算工资
     */
    public Wages totalWages(User user,String format){
        Wages wagesEntity = new Wages();

        Double finalWages;//最终工资

        Long wages = user.getWages();//固定工资
        Long achieveWages = user.getAchieveWages();//绩效工资
        Double achievements = user.getAchievements();//绩点
        Double deptAchievements = user.getDepartment().getAchievements();//部门绩效

        finalWages = wages + (deptAchievements * (achieveWages * 0.3)) + (achievements * (achieveWages * 0.7));

        wagesEntity.setUser(user);
        wagesEntity.setWages(wages);
        wagesEntity.setAchieveWages(achieveWages);
        wagesEntity.setAchievements(achievements);
        wagesEntity.setDepartmentAchievements(deptAchievements);
        wagesEntity.setBonus(0L);
        wagesEntity.setTax(0L);
        wagesEntity.setRemark(format);
        wagesEntity.setTotalWages(finalWages.longValue());
        wagesEntity.setCreateTime(new Date());
        wagesEntity.setState(0);
        return wagesEntity;

    }

    /**
     * 下发工资
     * @return
     */
    @RequestMapping("sendWages")
    @ResponseBody
    public ExecuteResult sendWages(){

        Long sum = 0L;
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String format = DateFormatUtils.format(time, "yyyy-MM");
        List<Wages> list = wagesService.findWagesByRemark(format);
        if(!(CollectionUtils.isEmpty(list))&&list.get(0).getState().equals(0)){
            sum = list.stream().mapToLong(Wages::getTotalWages).sum();
        }else{
            return ExecuteResult.fail("未生成工资条或已发放");
        }
        Company company = companyRepository.findAll().get(0);
        Long cost = company.getCost();
        if(cost<sum){
            return ExecuteResult.fail("工资账户余额不足");
        }
        list.stream().forEach(o->{
            o.setState(1);
            wagesService.saveOrUpdate(o);
        });
        cost = cost - sum;
        IORecord ioRecord = new IORecord();
        ioRecord.setType(format+"工资发放");
        ioRecord.setPrice(-sum);
        ioRecord.setUser(getUser());
        ioRecord.setCompany(company);
        ioRecord.setCreateTime(new Date());
        ioRecordService.saveOrUpdate(ioRecord);
        company.setCost(cost);
        companyRepository.saveAndFlush(company);

        return ExecuteResult.ok();

    }
}
