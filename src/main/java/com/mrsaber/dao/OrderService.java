package com.mrsaber.dao;

import com.mrsaber.mapper.OrderMapper;
import com.mrsaber.model.*;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ZY on 2017/11/12.
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SupplierService supplierService;

    /**
     * 【添加订单】
     * @param order
     * @return
     */
    public Order addOrder(Order order)
    {
        Goods goods =goodsService.getGoodsById(order.getOr_goods_id());
        //设置供应商
        order.setOr_supplier_id(goods.getSu_supplier());
        //计算总计
        order.setOr_total(0.0);
        //通过供应商ID获得供应商对象获得办公室，最后设置
        order.setSupplier_office(supplierService.getSupplierById(order.getOr_supplier_id()).getSupplier_office());
        orderMapper.addOrder(order);
        return order;
    }

    /**
     * 【获得所有库存】
     * @return
     */
    public List<Order> getAllOrder()
    {
        List<Order> orders = orderMapper.getAllOrder();
        return orders;
    }
    public List<Order> getBySup(Integer id)
    {
        return orderMapper.getBySup(id);
    }

    public List<Order> getGoodsInfoInBound(Integer id)
    {
        return orderMapper.getGoodsInfoInBound(id);
    }
    public List<Order> getOrderWhereCheck(Integer i){return orderMapper.getOrderWhereCheck(i);}

    /**
     * 删除订单
     * @param id
     */
    public void delOrderById(Integer id){orderMapper.deleteOrderById(id);}

    /**
     * 进货入库
     * @return
     */
    public void orderInBound(Integer id)
    {
        orderMapper.orderInBound(id);
    }

    /**
     * 获得统计数据
     * @return
     */
    public List<Statistics> getStatistics(){return orderMapper.getStatistics();}


    public List<Order> getLikeOrderInBound(String like)
    {
        return orderMapper.getLikeOrderInBound("%"+like+"%");
    }
    public void updateOrderNumInBound(Integer or_id, Double cost){orderMapper.updateOrderNumInBound(new UpdateItem(or_id,cost));}

    public void refreshOrderInBound()
    {
        orderMapper.refreshOrderInBound();
    }
    /**
     * 根据供货商和日期获得进货记录
     * */
    public List<Order> getOrderByDateAndSupplierId(OfIdAndDateItem item){return orderMapper.getOrderByDateAndSupplierId(item);}
    /**
     * 获得库存预警信息
     */
    public List<Order> getBoundAlarm()
    {
        return orderMapper.getBoundAlarm();
    }
    /**
     * 重设预警阀值
     */
    public void resetAlarm(Integer key,Integer val)
    {
        orderMapper.resetAlarm(val,key);
    }
    /**
     * 设置发票状况
     */
    public void setInvoice(Integer key,Integer value)
    {
        orderMapper.setInvoice(key,value);
    }

    /**
     * 结款
     * @param id
     */
    public void setPayment(Integer id)
    {
        orderMapper.setPayment(id);
    }
    /**
     * 到期预警订单
     */
    public List<Order> getBoundDeadDate(Date time)
    {
        return orderMapper.getBoundDeadDate(time);
    }

    /**
     *获得公司库存
     */
    public List<Order> getBySupplierId(Integer id)
    {
        return  orderMapper.getBySupplierId(id);
    }
    /**
     * 获得库存金额
     */
    public Double getAmount()
    {
        return orderMapper.getAmount();
    }
    /**
     * 修改订单备注
     */
    public void updateOther(Integer key, String val)
    {
        orderMapper.updateOther(val,key);
    }
}

