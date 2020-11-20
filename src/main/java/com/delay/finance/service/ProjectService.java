package com.delay.finance.service;

import com.delay.finance.entity.Project;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
public interface ProjectService {
    List<Project> findByUserId(Integer userId);
}
