package com.delay.finance.controller;

import com.delay.finance.entity.Department;
import com.delay.finance.entity.Type;
import com.delay.finance.entity.User;
import com.delay.finance.service.DepartmentService;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author 闫金柱
 * @create 2021-1-19 14:13
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("getAll")
    @ResponseBody
    public ExecuteResult getAll(){
        List<Department> departments = departmentService.findAll();
        return ExecuteResult.ok(departments);
    }

    @RequestMapping("add")
    @ResponseBody
    public ExecuteResult add(Department department){
        department.setCreateTime(new Date());
        departmentService.saveOrUpdate(department);
        return ExecuteResult.ok();
    }

    @RequestMapping("toEditDept")
    public String toEditDept(Integer deptId, Model model){

        Department department = departmentService.findById(deptId);
        model.addAttribute("dept",department);
        return "dept/dept-edit";
    }

    @RequestMapping("editInfo")
    @ResponseBody
    public ExecuteResult editInfo(Department department){
        Department comDept = departmentService.findById(department.getId());
        BeanUtils.copyProperties(department,comDept,"createTime");
        departmentService.saveOrUpdate(department);
        return ExecuteResult.ok();
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ExecuteResult delete(@RequestBody List<Integer> deptIds){
        deptIds.stream().forEach(o->{
            departmentService.delete(o);
        });
        return ExecuteResult.ok();
    }

}
