package com.delay.finance.service;

import com.delay.finance.entity.Project;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
public interface ProjectService {
    List<Project> findByUserId(Integer userId);

    List<Project> getAll();

    List<Project> getAllByStatus(int i);

    Project findById(Integer projectId);

    void saveOrUpdate(Project project);

    void deleteById(Integer projectId);
}
