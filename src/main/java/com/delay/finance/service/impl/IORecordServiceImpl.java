package com.delay.finance.service.impl;

import com.delay.finance.entity.IORecord;
import com.delay.finance.repository.IORecordRepository;
import com.delay.finance.service.IORecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
@Service
public class IORecordServiceImpl implements IORecordService {

    @Autowired
    IORecordRepository ioRecordRepository;

    @Override
    public List<IORecord> findAll() {
        return ioRecordRepository.findAll();
    }

    @Override
    public void saveOrUpdate(IORecord ioRecord) {
        ioRecordRepository.saveAndFlush(ioRecord);
    }
}
