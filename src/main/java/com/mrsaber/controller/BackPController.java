package com.mrsaber.controller;

import com.mrsaber.mapper.BackPMapper;
import com.mrsaber.model.BackP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bp")
public class BackPController {
    @Autowired
    private BackPMapper backPMapper;
    @RequestMapping(value = "/add.do")
    public String add(BackP p)
    {
        try{backPMapper.add(p);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "退货成功";
    }
    @RequestMapping(value = "/get.do")
    public List<BackP> get(Integer id)
    {
        return backPMapper.get(id);
    }
}
