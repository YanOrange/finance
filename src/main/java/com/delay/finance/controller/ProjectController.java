package com.delay.finance.controller;

import com.delay.finance.entity.Project;
import com.delay.finance.service.ProjectService;
import com.delay.finance.utils.ExecuteResult;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("findProjectByUser")
    public ExecuteResult findProjectByUser(){
        Integer userId = getUser().getId();
        List<Project> list = projectService.findByUserId(userId);
        return ExecuteResult.ok(list);
    }

}
