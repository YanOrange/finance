package com.delay.finance.service.impl;

import com.delay.finance.entity.Department;
import com.delay.finance.repository.DepartmentRepository;
import com.delay.finance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:29
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Department department) {
        departmentRepository.saveAndFlush(department);
    }

    @Override
    public Department findById(Integer deptId) {
        return departmentRepository.findById(deptId).orElse(null);
    }

    @Override
    public void delete(Integer o) {
        departmentRepository.deleteById(o);
    }
}
