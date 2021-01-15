package com.delay.finance.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.delay.finance.entity.Type;
import com.delay.finance.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2021-1-11 15:36
 */
@Data
public class ProjectExcel {

    @Excel(name = "业务名", orderNum = "0")
    private String name;//项目，业务名
    @Excel(name = "描述", orderNum = "1")
    private String description;//描述
    @Excel(name = "收支", orderNum = "2")
    private String isRecharge;//recharge 收入  expend 支出
    @Excel(name = "类型", orderNum = "3")
    private String type;
    @Excel(name = "金额", orderNum = "4")
    private Long price;//金额
    @Excel(name = "审核状态", orderNum = "5",replace = { "审核中_0","通过_1","拒绝_2"})
    private Integer status;//审核状态 0审核中 1通过 2拒绝
    @Excel(name = "申请人", orderNum = "6")
    private String user;//申请人
    @Excel(name = "审核人", orderNum = "7")
    private String admin;//审核人
    @Excel(name = "创建时间", orderNum = "8")
    private String createTime;//创建时间

    public ProjectExcel() {
    }

    public ProjectExcel(String name, String description, String isRecharge, String type, Long price, Integer status, String user, String admin, String createTime) {
        this.name = name;
        this.description = description;
        this.isRecharge = isRecharge;
        this.type = type;
        this.price = price;
        this.status = status;
        this.user = user;
        this.admin = admin;
        this.createTime = createTime;
    }
}
