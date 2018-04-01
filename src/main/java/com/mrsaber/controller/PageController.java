package com.mrsaber.controller;

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
        return "page_curd_goods";
    }
    /**
     * 供货人管理
     * @return
     */
    @RequestMapping(value = "supplier.html")
    public String supplier_html()
    {
        return "page_curd_supplier";
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
        return "page_bound";
    }
    /**
     * 订货入库
     */
    @RequestMapping(value = "inbound.html")
    public String inbound_html()
    {
        return "page_inbound_check";
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
        return "page_outbound_check";
    }
    /**
     * 历史出货
     */
    @RequestMapping(value = "sale_history.html")
    public String sale_history_html()
    {
        return "page_sale_history";
    }
    /**
     * 历史入库
     */
    @RequestMapping(value = "order_history.html")
    public String order_history_html()
    {
        return "page_inbound_history";
    }
    /**
     * 库存预警
     */
    @RequestMapping(value = "order_alarm.html")
    public String order_alarm_html(){return "page_order_alarm";}
    /**
     * 到期提醒
     */
    @RequestMapping(value = "order_dead.html")
    public String order_dead_html(){return "page_order_dead";}
    /**
     * 购物车
     */
    @RequestMapping(value = "shopcar.html")
    public String shopcar_html()
    {
        return "page_shopcar";
    }

    /**
     * 出货新
     */
    @RequestMapping(value = "page_sale_new.html")
    public String sale_new_html()
    {
        return "page_sale_new";
    }
    /**
     * 出货新
     */
    @RequestMapping(value = "page_purchase_new.html")
    public String page_purchase_new()
    {
        return "page_purchase_new";
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
    @RequestMapping(value = "page_index_viewer.html")
    public String page_index_viewer(){return "page_index_viewer";}

    @RequestMapping(value = "admin_user.html")
    public String admin_user_html(){return "page_admin_user";}

    @RoleCheck(level = {3})
    @RequestMapping(value = "page_admin.html")
    public String page_admin_html(){return "page_admin";}

    @RequestMapping(value = "page_index.html")
    public String page_index_html(){return "page_index";}

    @RequestMapping(value = "page_order_viewer.html")
    public String page_order_viewer(){return "page_bound_viewer";}
}
