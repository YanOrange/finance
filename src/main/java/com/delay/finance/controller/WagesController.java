package com.delay.finance.controller;

import com.delay.finance.entity.Wages;
import com.delay.finance.service.WagesService;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:26
 */
@Controller
@RequestMapping("wages")
public class WagesController extends BaseController{

    @Autowired
    WagesService wagesService;

    @RequestMapping("findWagesByUser")
    @ResponseBody
    public ExecuteResult findWagesByUser(){
        Integer userId = getUser().getId();

        List<Wages> list = wagesService.findByUserId(userId);

        return ExecuteResult.ok(list);

    }

}
