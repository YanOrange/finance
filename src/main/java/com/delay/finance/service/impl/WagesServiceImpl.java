package com.delay.finance.service.impl;

import com.delay.finance.entity.Wages;
import com.delay.finance.repository.WagesRepository;
import com.delay.finance.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
@Service
public class WagesServiceImpl implements WagesService {

    @Autowired
    WagesRepository wagesRepository;

    @Override
    public List<Wages> findByUserId(Integer userId) {
        return wagesRepository.findByUserId(userId);
    }

    @Override
    public List<Wages> findWagesByRemark(String remark) {
        return wagesRepository.findByRemark(remark);
    }

    @Override
    public void saveOrUpdate(Wages wages) {
        wagesRepository.saveAndFlush(wages);
    }
}
