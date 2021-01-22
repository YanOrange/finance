package com.delay.finance.controller;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.delay.finance.entity.Company;
import com.delay.finance.entity.IORecord;
import com.delay.finance.entity.Project;
import com.delay.finance.repository.CompanyRepository;
import com.delay.finance.service.IORecordService;
import com.delay.finance.service.ProjectService;
import com.delay.finance.utils.ExcelUtils;
import com.delay.finance.utils.ExecuteResult;
import com.delay.finance.vo.IORecordExcel;
import com.delay.finance.vo.ProjectExcel;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-20 16:31
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController {

    @Autowired
    ProjectService projectService;
    @Autowired
    IORecordService ioRecordService;
    @Autowired
    CompanyRepository companyRepository;

    @ResponseBody
    @RequestMapping("findProjectByUser")
    public ExecuteResult findProjectByUser(){
        Integer userId = getUser().getId();
        List<Project> list = projectService.findByUserId(userId);
        return ExecuteResult.ok(list);
    }

    /**
     * 导出项目报表
     * @param response
     * @return
     */
    @RequestMapping("downProject")
    @ResponseBody
    public void downProject(HttpServletResponse response){
        String fileName = "项目收支报表" + DateFormatUtils.format(new Date(), "yyyyMMddhhmmss") + ".xls";
        List<ProjectExcel> list = new ArrayList<>();
        List<Project> projectList = projectService.getAllByStatus(1);
        projectList.stream().forEach(o->{
            list.add(new ProjectExcel(o.getName(),o.getDescription(),o.getIsRecharge(),o.getType().getName(),o.getPrice(),o.getStatus(),o.getUser().getName(),o.getAdmin().getName(), DateFormatUtils.format(o.getCreateTime(),"yyyy-MM-dd HH:mm:ss")));

        });
        ExcelUtils.exportExcel(list, "项目收支报表", "项目收支报表",ProjectExcel.class, fileName,true, response);
        System.out.println(fileName + "导出成功");
    }

    /**
     * 导出工资条报表
     * @param response
     * @return
     */
    @RequestMapping("downIO")
    @ResponseBody
    public void downIO(HttpServletResponse response){
        String fileName = "工资条报表" + DateFormatUtils.format(new Date(), "yyyyMMddhhmmss") + ".xls";
        List<IORecordExcel> list = new ArrayList<>();
        List<IORecord> ioRecords = ioRecordService.findAll();
        ioRecords.stream().forEach(o->{
            list.add(new IORecordExcel(o.getType(),o.getPrice(),o.getUser().getName(),DateFormatUtils.format(o.getCreateTime(),"yyyy-MM-dd HH:mm:ss")));

        });
        ExcelUtils.exportExcel(list, "工资条报表", "工资条报表",IORecordExcel.class, fileName,true, response);
        System.out.println(fileName + "导出成功");
    }

    /**
     * 通过status获取业务明细
     * @return
     */
    @RequestMapping("getProjectByStatus")
    @ResponseBody
    public ExecuteResult getProjectByStatus(Integer status){
        List<Project> projectList = projectService.getAllByStatus(status);
        return ExecuteResult.ok(projectList);
    }

    /**
     * 通过/打回
     * @return
     */
    @RequestMapping("setStatus")
    @ResponseBody
    public ExecuteResult setStatus(Integer projectId,Integer status){
        Company company = companyRepository.findAll().get(0);
        Project project = projectService.findById(projectId);
        project.setStatus(status);
        project.setAdmin(getUser());
        projectService.saveOrUpdate(project);
        if(status.equals(1)){
            IORecord ioRecord = new IORecord();
            ioRecord.setType(project.getType().getName());
            ioRecord.setPrice(project.getPrice());
            ioRecord.setUser(project.getAdmin());
            ioRecord.setCompany(company);
            ioRecord.setCreateTime(new Date());
            ioRecordService.saveOrUpdate(ioRecord);
        }


        return ExecuteResult.ok();
    }

    /**
     * 添加（申请）
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ExecuteResult add(Project project){
        Double dPrice = project.getDPrice();
        if(project.getIsRecharge().equals("recharge")){//收入
            dPrice = dPrice * 100;
            project.setPrice(dPrice.longValue());
        }else{
            dPrice = dPrice * 100;
            project.setPrice(-dPrice.longValue());
        }
        project.setStatus(0);
        project.setCreateTime(new Date());
        project.setUser(getUser());
        projectService.saveOrUpdate(project);
        return ExecuteResult.ok();
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("refuse")
    @ResponseBody
    public ExecuteResult refuse(Integer projectId){
        projectService.deleteById(projectId);
        return ExecuteResult.ok();
    }



}
