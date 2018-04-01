package com.mrsaber.controller;

import com.mrsaber.mapper.ShopCartMapper;
import com.mrsaber.model.ShopCart;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sc")
@CrossOrigin
public class ShopCarController {
    @Autowired
    private ShopCartMapper shopCartMapper;

    @RequestMapping("/get.do")
    public List<ShopCart> get()
    {
        return shopCartMapper.getCuItems();
    }
    @RoleCheck(level = {3})

    @RequestMapping("/del.do")
    public String del(Integer id)
    {
        try{shopCartMapper.deleteItemById(id);}
        catch (Exception e)
        {e.printStackTrace();return e.getMessage();}
        return "删除成功";
    }

    /**
     * 清空购物车
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping("/delAll.do")
    public String delAll()
    {
        try{shopCartMapper.delteAll();}
        catch (Exception e)
        {e.printStackTrace();return e.getMessage();}
        return "删除成功";
    }

    /**
     * 购物车添加
     * @param sc
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping("/add.do")
    public String add(ShopCart sc)
    {
        try{shopCartMapper.addItem(sc);}
        catch (Exception e)
        {e.printStackTrace();return e.getMessage();}
        return "添加成功";
    }

}
