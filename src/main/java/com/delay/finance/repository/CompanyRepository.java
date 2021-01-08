package com.delay.finance.repository;

import com.delay.finance.entity.Company;
import com.delay.finance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author 闫金柱
 * @create 2021-1-8 15:55
 */
@Repository
@Component
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
