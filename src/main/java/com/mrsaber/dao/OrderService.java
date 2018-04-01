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


    /*-----[CURD]-----*/
    public void delById(Integer id){orderMapper.deleteOrderById(id);}
    public Order getById(Integer id)
    {
        return orderMapper.getById(id);
    }
    public Order add(Order order)
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


//  public List<Statistics> getStatistics(){return orderMapper.getStatistics();}
    public Double getAmount()
    {
        return orderMapper.getAmount();
    }


    public void setBound(Integer id)
    {
        orderMapper.orderInBound(id);
    }

    public void setInvoice(Integer key,Integer value)
    {
        orderMapper.setInvoice(key,value);
    }

    public void setPayment(Integer id)
    {
        orderMapper.setPayment(id);
    }

    public void setAlarm(Integer key,Integer val)
    {
        orderMapper.resetAlarm(val,key);
    }

    public void setOther(Integer key, String val)
    {
        orderMapper.updateOther(val,key);
    }



    public List<Order> getList(){return orderMapper.getList();}

    public List<Order> getListByAlarm()
    {
        return orderMapper.getBoundAlarm();
    }

    public List<Order> getListByLikeName(String like)
    {
        return orderMapper.getLikeOrderInBound("%"+like+"%");
    }

    public List<Order> getListByNo(String like)
    {
        return orderMapper.getListByNo("%"+like+"%");
    }

    public List<Order> getListByDead(Date time)
    {
        return orderMapper.getListByDead(time);
    }

    public List<Order> getListBySupId(Integer id)
    {
        return  orderMapper.getListBySupId(id);
    }

    public List<Order> getListByDateAndSupId(OfIdAndDateItem item){return orderMapper.getOrderByDateAndSupplierId(item);}

    public List<Order> getListByStatus(Integer i){return orderMapper.getOrderWhereCheck(i);}

    public List<Order> getListByPageAndRow(Integer page,Integer row)
    {
        List<Order> orders = orderMapper.getListByPageAndRow(row,(page-1)*row);
        return orders;
    }
    public List<Order> getListByInbound(Integer id)
    {
        return orderMapper.getGoodsInfoInBound(id);
    }

}

