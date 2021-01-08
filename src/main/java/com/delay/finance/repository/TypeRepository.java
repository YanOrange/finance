package com.delay.finance.repository;

import com.delay.finance.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author 闫金柱
 * @create 2021-1-8 16:18
 */
@Repository
@Component
public interface TypeRepository extends JpaRepository<Type,Integer> {
}
