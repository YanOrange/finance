package com.delay.finance.controller;

import com.delay.finance.repository.TypeRepository;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2021-1-8 16:17
 */
@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeRepository typeRepository;

    /**
     * 删除类型
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ExecuteResult delete(@RequestBody List<Integer> ids){
        ids.stream().forEach(o->{
            typeRepository.deleteById(o);
        });
        return ExecuteResult.ok();
    }

    @RequestMapping("getAll")
    @ResponseBody
    public ExecuteResult getAll(){
        return ExecuteResult.ok(typeRepository.findAll());
    }

}
