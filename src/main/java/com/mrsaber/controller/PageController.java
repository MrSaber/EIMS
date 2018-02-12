package com.mrsaber.controller;

import com.mrsaber.dao.GoodsService;
import com.mrsaber.security.RoleCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 物品管理
     * @return
     */
    @RequestMapping(value = "goods.html")
    public String goods_html()
    {

        return "goods";
    }
    /**
     * 供货人管理
     * @return
     */
    @RequestMapping(value = "supplier.html")
    public String supplier_html()
    {
        return "supplier";
    }

    /**
     * 客户管理
     * @return
     */
    @RequestMapping(value = "customer.html")
    public String customer_html()
    {
        return "customer";
    }

    /**
     * 购买管理
     * @return
     */
    @RequestMapping(value = "purchase.html")
    public String purchase_html(Model model)
    {

        return "purchase";
    }
    /**
     * 库存查询
     */
    @RequestMapping(value = "order.html")
    public String order_html()
    {
        return "order";
    }
    /**
     * 订货入库
     */
    @RequestMapping(value = "inbound.html")
    public String inbound_html()
    {
        return "inbound";
    }
    /**
     * 出货
     */
    @RequestMapping(value = "sale.html")
    public String sale_html()
    {
        return "sale";
    }
    /**
     * 出货查询
     */
    @RequestMapping(value = "sale_query.html")
    public String sale_query_html()
    {
        return "sale_query";
    }
    /**
     * 历史出货
     */
    @RequestMapping(value = "sale_history.html")
    public String sale_history_html()
    {
        return "sale_history";
    }
    /**
     * 历史入库
     */
    @RequestMapping(value = "order_history.html")
    public String order_history_html()
    {
        return "order_history";
    }
    /**
     * 库存预警
     */
    @RequestMapping(value = "order_alarm.html")
    public String order_alarm_html(){return "order_alarm";}
    /**
     * 到期提醒
     */
    @RequestMapping(value = "order_dead.html")
    public String order_dead_html(){return "order_dead";}
    /**
     * 购物车
     */
    @RequestMapping(value = "shopcar.html")
    public String shopcar_html()
    {
        return "shopcar";
    }

    /**
     * 管理员界面
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "admin.html")
    public String admin_html()
    {
        return "admin";
    }

    @RoleCheck(level = {1})
    @RequestMapping(value = "shenhe.html")
    public String shenhe_html()
    {
        return "shenhe";
    }

    @RoleCheck(level = {2})
    @RequestMapping(value = "chakan.html")
    public String chakan_html(){return "chakan";}

    @RequestMapping(value = "admin_user.html")
    public String admin_user_html(){return "admin_user";}
}
