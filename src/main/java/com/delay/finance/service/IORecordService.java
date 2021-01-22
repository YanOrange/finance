package com.delay.finance.service;

import com.delay.finance.entity.IORecord;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
public interface IORecordService {
    List<IORecord> findAll();

    void saveOrUpdate(IORecord ioRecord);
}
