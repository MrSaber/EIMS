package com.mrsaber.controller;

import com.mrsaber.dao.LabService;
import com.mrsaber.model.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lab")
public class LabController {
    @Autowired
    private LabService labService;
    @RequestMapping("/add.do")
    public String add(Lab lab)
    {
        try{
            labService.addLab(lab);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "添加失败";
        }
        return "添加成功";
    }


    @RequestMapping("/del.do")
    public String del(Integer id)
    {
        try{
            labService.delLab(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/gets.do")
    public List<Lab> get(int key)
    {
        return labService.getLabByBranchId(key);
    }
}
