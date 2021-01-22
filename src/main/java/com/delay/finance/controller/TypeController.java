package com.delay.finance.controller;

import com.delay.finance.entity.Type;
import com.delay.finance.repository.TypeRepository;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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

    @RequestMapping("add")
    @ResponseBody
    public ExecuteResult add(Type type){

        type.setCreateTime(new Date());
        typeRepository.saveAndFlush(type);

        return ExecuteResult.ok();
    }

    @RequestMapping("toEditType")
    public String toEditType(Integer typeId, Model model){

        Type byId = typeRepository.findById(typeId).orElse(null);
        model.addAttribute("type",byId);
        return "type/type-edit";
    }

    @RequestMapping("editInfo")
    @ResponseBody
    public ExecuteResult editInfo(Type type){

        Type byId = typeRepository.findById(type.getId()).orElse(null);
        BeanUtils.copyProperties(type,byId,"createTime");
        typeRepository.saveAndFlush(byId);

        return ExecuteResult.ok();
    }








}
