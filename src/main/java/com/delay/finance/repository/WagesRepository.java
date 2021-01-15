package com.delay.finance.repository;

import com.delay.finance.entity.User;
import com.delay.finance.entity.Wages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:29
 */
@Repository
@Component
public interface WagesRepository extends JpaRepository<Wages,Integer> {
    List<Wages> findByUserId(Integer userId);

    List<Wages> findByRemark(String remark);
}
