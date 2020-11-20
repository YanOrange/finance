package com.delay.finance.repository;

import com.delay.finance.entity.Department;
import com.delay.finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:29
 */
@Repository
@Component
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
