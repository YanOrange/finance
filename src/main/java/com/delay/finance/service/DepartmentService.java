package com.delay.finance.service;

import com.delay.finance.entity.Department;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:29
 */
public interface DepartmentService {
    List<Department> findAll();

    void saveOrUpdate(Department department);

    Department findById(Integer deptId);

    void delete(Integer o);
}
