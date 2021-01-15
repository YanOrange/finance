package com.delay.finance.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.delay.finance.entity.Company;
import com.delay.finance.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2020-11-18 17:14
 */
@Data
public class IORecordExcel {

    @Excel(name = "收支类型", orderNum = "0")
    private String type;//收支类型
    @Excel(name = "金额", orderNum = "1")
    private Long price;//金额

    @Excel(name = "负责人", orderNum = "2")
    private String user;//负责人

    @Excel(name = "创建时间", orderNum = "3")
    private String createTime;//创建时间

    public IORecordExcel(String type, Long price, String user, String createTime) {
        this.type = type;
        this.price = price;
        this.user = user;
        this.createTime = createTime;
    }

    public IORecordExcel() {
    }
}
