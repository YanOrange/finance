package com.delay.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2020-11-18 17:14
 */
@Entity
@Data
@Table(name = "t_io_record")
public class IORecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    private Integer id;

    private String type;//收支类型

    private Long price;//金额

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;//负责人

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;//创建时间

}
