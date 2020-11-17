package com.delay.finance.controller;


import com.delay.finance.entity.School;
import com.delay.finance.service.SchoolService;
import com.delay.finance.utils.ExecuteResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("school")
public class SchoolController extends BaseController{

    @Autowired
    SchoolService schoolService;
    /**
     * 获取全部类型
     * @return
     */
    @RequestMapping("getAll")
    @ResponseBody
    public ExecuteResult findAll(){
        List<School> list = schoolService.findAll();
        return ExecuteResult.ok(list);
    }
    /**
     * 更改类型页面
     * @return
     */
    @RequestMapping("toEditSchool")
    public String toEditType(@RequestParam("schoolId")Integer schoolId, Model model){

        School school = schoolService.findById(schoolId);
        model.addAttribute("school",school);

        return "school/school-edit";
    }
    /**
     * 更改类型
     * @return
     */
    @RequestMapping("editInfo")
    @ResponseBody
    public ExecuteResult editInfo(@RequestBody School school){
        School byId = schoolService.findById(school.getId());
        BeanUtils.copyProperties(school,byId,"createTime");
        schoolService.saveOrUpdate(byId);
        return ExecuteResult.ok();
    }
    /**
     *  删除类型
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ExecuteResult delete(@RequestBody List<Integer> ids){
        if(CollectionUtils.isEmpty(ids)){
            return ExecuteResult.fail(1,"未选择一列");
        }
        ids.stream().forEach(o->{
            schoolService.delete(o);
        });
        return ExecuteResult.ok();
    }
    /**
     * 添加类型
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ExecuteResult delete(@RequestBody School school){
        School byName = schoolService.findByName(school.getName());
        if(byName!=null){
            return ExecuteResult.fail(1,"该高校已存在");
        }
        school.setCreateTime(new Date());
        schoolService.saveOrUpdate(school);
        return ExecuteResult.ok();
    }

}
