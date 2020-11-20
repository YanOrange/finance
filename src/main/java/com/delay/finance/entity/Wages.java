package com.delay.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 闫金柱
 * @create 2020-11-18 17:33
 */
@Entity
@Data
@Table(name = "t_wages")
public class Wages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    private Integer id;

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;

    private Long wages;//固定工资

    private Long achieveWages;//绩效工资

    private Double achievements;//个人绩效

    private Double departmentAchievements;//部门绩效

    private Long bonus;//奖金

    private Long tax;//税

    private String remark;//区别几月工资

    private Long totalWages;//实发工资

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;//创建时间

}
