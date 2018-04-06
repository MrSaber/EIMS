package com.mrsaber.controller;

import com.mrsaber.dao.GoodsService;
import com.mrsaber.model.Goods;
import com.mrsaber.model.onePage;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 物品管理
 */
@RestController
@RequestMapping("goods")
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    /**、
     * 【获得所有物品信息】
     * @return
     */
    @RequestMapping(value = "/get.do")
    @Transactional
    public List<Goods> getAllGoods(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows )
    {
        try {
            return goodsService.getAllGoods();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @RequestMapping(value = "/getByPage.do")
    @Transactional
    public onePage getListByPage(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "50")Integer rows )
    {
        try {
            return goodsService.getListByPage(rows,(page-1)*rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


    /**
     * 【增加物品】
     * @param goods
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public String addGoods(Goods goods)
    {
        try {
            goodsService.addGoods(goods);
        }catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "数据添加成功！";
    }


    /**
     * 【删除物品】
     * @param goodsID
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/del.do",method = RequestMethod.POST)
    public String delGoods(Integer goodsID)
    {
        try {
            goodsService.delGoodsById(goodsID);
        }catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "数据删除成功";
    }

    /**
     *【模糊查询获得货品列表】
     */
    @RequestMapping(value = "/getLike.do")
    public List<Goods> getGoodsLike(String like,Integer type)
    {
        try {
            switch (type)
            {
                case 1:return goodsService.getListByLikeName(like);
                case 2:return  goodsService.getListByLikeNo(like);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }


    /**
     * 【更新货品信息】
     * @param goods
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/update.do")
    public String updateGoods(Goods goods)
    {
        try {
            goodsService.updateById(goods);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "更新成功！";
    }
}