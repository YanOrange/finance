package com.delay.finance.controller;

import com.delay.finance.entity.Company;
import com.delay.finance.entity.IORecord;
import com.delay.finance.repository.CompanyRepository;
import com.delay.finance.service.IORecordService;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author 闫金柱
 * @create 2021-1-8 11:49
 */
@Controller
@RequestMapping("ioRecord")
public class IORecordController {

    @Autowired
    IORecordService ioRecordService;
    @Autowired
    CompanyRepository companyRepository;

    private long fixedCost = 100000000;//初始资产100万

    @RequestMapping("refreshCost")
    @ResponseBody
    public ExecuteResult refreshCost(){
        final long[] nowCost = {fixedCost};
        List<IORecord> list = ioRecordService.findAll();
        list.stream().forEach(o->{
//            if("expend".equals(o.getType())){//支出
                nowCost[0] = nowCost[0] + o.getPrice();
//            }else if("recharge".equals(o.getType())){//收入
//
//            }
        });
        Company company = companyRepository.findAll().get(0);
        company.setCost(nowCost[0]);
        return ExecuteResult.ok(company);
    }

}
