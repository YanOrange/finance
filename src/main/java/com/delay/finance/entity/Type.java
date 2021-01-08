package com.delay.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2021-1-8 16:15
 */
@Entity
@Table(name="t_type")
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

}
