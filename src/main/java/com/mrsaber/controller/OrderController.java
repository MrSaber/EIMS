package com.mrsaber.controller;

import com.mrsaber.dao.OrderService;
import com.mrsaber.model.OfIdAndDateItem;
import com.mrsaber.model.Order;
import com.mrsaber.model.OrderItem;
import com.mrsaber.model.Statistics;
import com.mrsaber.security.RoleCheck;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 库存及订单操作
 */
@RestController
@RequestMapping(value = "order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 【添加订单】
     * @param order
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/add.do")
    public String addOrder(Order order)
    {
        try {
            orderService.add(order);
            return "操作成功";
        } catch (Exception e) {
            e.printStackTrace();
           return "操作失败,请重试";
        }
    }

    /**
     * 【删除进货订单】
     * @param id
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/del.do")
    public String delOrder(Integer id)
    {
        try {
            orderService.delById(id);
        } catch (Exception e) {
            return "删除失败！";
        }
        return "删除成功！";
    }

    /**
     * 【获得所有库存记录】
     * @return
     */
    @RequestMapping(value = "/getAll.do")
    public List<Order> getListByPageAndRow()
    {
        try {
            return orderService.getList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value="/search.do")
    public List<Order> getLikeOrder(Integer id)
    {
        return orderService.getListByInbound(id);
    }

    /**
     * 【获得待入库的订单】
     * @return
     */
    @RequestMapping(value = "/getCheck.do")
    public List<Order> getCheckOrder()
    {
        return orderService.getListByStatus(1);
    }

    /**
     * 【入库操作】
     * @param token
     * @param id
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/inbound.do")
    public String orderInBound(Integer token,Integer id)
    {
        System.out.println(token+"|"+id);
        try {
            orderService.setBound(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "入库失败";
        }
        return "入库成功";
    }
    /**
     * 【模糊查找数据】
     * @param like
     * @return
     */
    @RequestMapping(value = "/getListByLikeName.do")
    public List<Order> getLike(String like,Integer type)
    {
        try {
            switch (type)
            {
                case 1:return orderService.getListByLikeName(like);
                case 2:return orderService.getListByNo(like);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

/*
    @RequestMapping(value = "/getStatistics.do")
    public List<Statistics> getStatistics()
    {
        try {
            return orderService.getStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/

    /**
     * 【获得库存总额】
     * @return
     */
    @RequestMapping(value = "/getAmount.do")
    public Double getAmount()
    {
        return orderService.getAmount();
    }
    /**
     * 【日期规则筛选库存】
     * @param item
     * @return
     */
    @RequestMapping(value = "/getOrderByDateAndSupplierId.do")
    public List<Order> getOrderByDateAndSupplierId(OfIdAndDateItem item)
    {
        try {
            return orderService.getListByDateAndSupId(item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 【获得预警库存信息】
     */
    @RequestMapping(value = "/getBoundAlarm.do")
    public List<Order> getBoundAlarm()
    {
        return orderService.getListByAlarm();
    }

    /**
     * 【重设预计阀值】
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/resetAlarm.do")
    public String resetAlarm(Integer key,Integer val)
    {
        try {
            orderService.setAlarm(key,val);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "出现错误，请重试";
        }
        return "重置成功，请刷新";
    }

    /**
     * 【设置发票状况】
     * @param key
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/setInvoice.do")
    public String setInvoice(Integer key,Integer value)
    {
        try{orderService.setInvoice(key,value);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "更改成功";

    }

    /**
     * 【设置结账情况】
     * @param id
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/setPayment.do")
    public String setPayment(Integer id)
    {
        try{orderService.setPayment(id);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "结账成功";
    }

    /**
     * 获得所有进货信息根据排序
     */
    @RequestMapping(value = "/getList.do")
    public List<Order> getList()
    {
        return  orderService.getList();
    }


    /**
     * 获得所有进货信息根据排序
     */
    @RequestMapping(value = "/getRecent.do")
    public List<Order> getListByPageAndRow(Integer page,Integer rows)
    {
        return  orderService.getListByPageAndRow(page,rows);
    }

    /**
     * 获得到期预警订单
     */
    @RequestMapping(value = "/getListByDead.do")
    public List<Order> getListByDead(String deaddate)
    {
        SimpleDateFormat sdf =new SimpleDateFormat( "MM/dd/yyyy" );
        Date time = new Date();
        try {
             time =sdf.parse(deaddate);
             System.out.println(time);
        } catch (Exception e) {

        }
        return orderService.getListByDead(time);
    }
    /**
     *
     * 获得公司库存
     */
    @RequestMapping(value = "/getListBySupId.do")
    public List<Order> getBySupplierId(Integer id)
    {
        return orderService.getListBySupId(id);
    }


    @RequestMapping(value = "/getById.do")
    public Order getById(Integer id)
    {
        return orderService.getById(id);
    }


    /**
     * 修改库存备注
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/updateOther.do")
    public String updateOther(String val,Integer key)
    {
        try {
            orderService.setOther(key,val);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "更新成功";
    }
}
