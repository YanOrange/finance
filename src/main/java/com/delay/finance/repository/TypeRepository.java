package com.delay.finance.repository;

import com.delay.finance.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TypeRepository extends JpaRepository<Type,Integer> {


    Type findByName(String name);
}
