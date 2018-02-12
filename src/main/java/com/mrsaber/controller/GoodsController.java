package com.mrsaber.controller;

import com.mrsaber.dao.GoodsService;
import com.mrsaber.model.Goods;
import com.mrsaber.model.GoodsItem;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 物品管理
 */
@RestController
@CrossOrigin
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    /**、
     * 【获得所有物品信息】
     * @return
     */
    @RequestMapping(value = "/get.do")
    public List<Goods> getAllGoods()
    {
        return goodsService.getAllGoods().getData();
    }

    /**
     * 【增加物品】
     * @param goods
     * @return
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/2.do",method = RequestMethod.POST)
    public String addGoods(Goods goods)
    {
        try {
            goodsService.addGoods(goods);
        }catch (Exception e)
        {
            return "数据录入异常！";
        }
        return "数据添加成功！";
    }


    /**
     * 【删除物品】
     * @param goodsID
     * @return
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/del.do",method = RequestMethod.POST)
    public String delGoods(Integer goodsID)
    {
        try {
            goodsService.delGoodsById(goodsID);
        }catch (Exception e)
        {
            return "数据删除异常！";
        }
        return "数据删除成功";
    }


    /**
     *【模糊查询获得货品列表】
     */
    @RequestMapping(value = "/getlike.do",method = RequestMethod.GET)
    public List<Goods> getGoodsLike(String like)
    {
        return goodsService.getGoodsLike(like);
    }

    /**
     * 【更新货品信息】
     * @param goods
     * @return
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/update.do")
    public String updateGoods(Goods goods)
    {
        try {
        goodsService.updateById(goods);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "OK";
    }

}
