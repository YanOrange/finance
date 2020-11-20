package com.delay.finance.repository;

import com.delay.finance.entity.IORecord;
import com.delay.finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:30
 */
@Repository
@Component
public interface IORecordRepository extends JpaRepository<IORecord,Integer> {
}
