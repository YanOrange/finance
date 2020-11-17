package com.delay.finance.service.impl;


import com.delay.finance.entity.Type;
import com.delay.finance.repository.TypeRepository;
import com.delay.finance.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;


    @Override
    public Type findById(Integer typeId) {
        Optional<Type> byId = typeRepository.findById(typeId);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Type byId) {
        typeRepository.saveAndFlush(byId);
    }

    @Override
    public void delete(Integer o) {
        typeRepository.deleteById(o);
    }

    @Override
    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }
}
