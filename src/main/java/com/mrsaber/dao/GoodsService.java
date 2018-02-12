package com.mrsaber.dao;

import com.mrsaber.mapper.GoodsMapper;
import com.mrsaber.model.Goods;
import com.mrsaber.model.GoodsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZY on 2017/11/9.
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    public GoodsItem getAllGoods()
    {
        List<Goods> goodses=goodsMapper.getAllGoods();
        System.out.println("共有物品数量为："+goodses.size());
        GoodsItem goodsItem = new GoodsItem();
        goodsItem.setCode(0);
        goodsItem.setMsg("Hello");
        goodsItem.setCount(goodses.size());
        goodsItem.setData(goodses);
        return goodsItem;
    }

    public void addGoods(Goods goods)
    {
        goodsMapper.addGoods(goods);
    }

    public void delGoodsById(Integer id)
    {
        goodsMapper.delGoodsById(id);
    }
    public List<Goods> getGoodsLike(String like)
    {
        like="%"+like+"%";
        List<Goods> goodses=goodsMapper.getGoodsLike(like);
        return goodses;
    }

    public Goods getGoodsById(Integer id)
    {
         return  goodsMapper.getGoodsById(id);
    }
    public void updateById(Goods goods){goodsMapper.updateById(goods);}
}
