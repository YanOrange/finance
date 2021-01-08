package com.delay.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2020-11-18 16:28
 */
@Entity
@Data
@Table(name = "t_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    private Integer id;

    private String name;//项目，业务名

    private String description;//描述

    private String isRecharge;//recharge 收入  expend 支出

    @JoinColumn(name="type_id")
    @ManyToOne
    private Type type;

    private Long price;//金额

    private Integer status;//审核状态 0审核中 1通过 2拒绝

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;//申请人

    @JoinColumn(name="admin_id")
    @ManyToOne
    private User admin;//审核人
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;//创建时间



}
