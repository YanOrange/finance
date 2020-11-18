package com.delay.finance.entity;

import lombok.Data;

import javax.persistence.*;

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

    private Long price;//金额

    private Integer status;//审核状态 0审核中 1通过 2拒绝



}
