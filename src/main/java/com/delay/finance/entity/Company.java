package com.delay.finance.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author 闫金柱
 * @create 2020-11-18 11:26
 */
@Entity
@Data
@Table(name = "t_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    private Integer id;

    private String name;//公司名

    private String address;//地址

    private String phone;//联系方式

    private Long cost;//账户余额

}
