package com.delay.finance.service;

import com.delay.finance.entity.Wages;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:27
 */
public interface WagesService {
    List<Wages> findByUserId(Integer userId);

    List<Wages> findWagesByRemark(String valueOf);
}
