package com.delay.finance.controller;

import com.delay.finance.entity.Wages;
import com.delay.finance.service.WagesService;
import com.delay.finance.utils.ExecuteResult;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
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


    /**
     * 根据月份查找工资明细
     * @return
     */
    @RequestMapping("findWagesByRemark")
    @ResponseBody
    public ExecuteResult findWagesByRemark(){
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String format = DateFormatUtils.format(time, "yyyy-MM-dd HH:mm:ss");
        List<Wages> list = wagesService.findWagesByRemark(format);

        return ExecuteResult.ok(list);

    }

    /**
     * 下发工资
     * @return
     */
    @RequestMapping("sendWages")
    @ResponseBody
    public ExecuteResult sendWages(){

        return null;

    }
}
