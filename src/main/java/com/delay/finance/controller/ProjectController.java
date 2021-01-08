package com.delay.finance.controller;

import com.delay.finance.entity.Project;
import com.delay.finance.service.ProjectService;
import com.delay.finance.utils.ExcelUtils;
import com.delay.finance.utils.ExecuteResult;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("findProjectByUser")
    public ExecuteResult findProjectByUser(){
        Integer userId = getUser().getId();
        List<Project> list = projectService.findByUserId(userId);
        return ExecuteResult.ok(list);
    }

    @RequestMapping("downProject")
    public ExecuteResult downProject(){
        String fileName = "和包美的商城订单明细" + DateFormatUtils.format(new Date(), "yyyyMMddhhmmss") + ".xls";
        List<OrderExcel> list = new ArrayList<>();
        List<Order> orderList = orderClient.getOrderList(orderVo);
        orderList.stream().forEach(o->{
            ExecuteResult<List<OrderDetail>> orderDetails = orderClient.getOrderDetails(o.getId());
            if(!orderDetails.isSuccess()){
                return ;
            }
            List<OrderDetail> detailsValue = orderDetails.getValue();
            detailsValue.stream().forEach(d->{
                list.add(new OrderExcel(o.getOrderNo(),d.getBuyNum(),d.getProName(),d.getProSku(),o.getShippingUser(),o.getShippingPhone(),o.getProvince(),o.getCity(),o.getCountry(),o.getShippingAddress(), DateFormatUtils.format(o.getCreateDate(),"yyyy-MM-dd HH:mm:ss"),o.getBackType(),o.getOrderState(),o.getTotalPrice(),o.getPrices(),o.getDeliveryCompany(),o.getTrackingNumber()));
            });

        });
        ExcelUtils.exportExcel(list, "和包美的商城订单明细", "和包美的商城订单明细",OrderExcel.class, fileName,true, response);
        logger.info(fileName + "导出成功");
    }

}
