package com.mrsaber.controller;

import com.mrsaber.dao.SaleService;
import com.mrsaber.model.OfIdAndDateItem;
import com.mrsaber.model.Sale;
import com.mrsaber.security.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 销售管理
 */
@RestController
@CrossOrigin
@RequestMapping(value = "sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    /**
     * 售货
     * @return
     */
    @RequestMapping(value = "/add.do")
    public String addSale(Sale sale)
    {
        System.out.println(sale);
        try {
            saleService.addSale(sale);
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败！";
        }
        return "操作成功";
    }

    /**
     * 删除
     * @param sale_id
     * @return
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/del.do")
    public String delSale(Integer sale_id)
    {
        saleService.delSaleById(sale_id);
        return "删除成功";
    }

    /**
     * 【待审核入库订单】
     * @return
     */
    @RequestMapping(value = "/getCheck.do")
    public List<Sale> getCheck()
    {
        return saleService.getAllSaleUnCheck();
    }

    /**
     * 【审核出货】
     * @param sale
     * @return
     */
    @RequestMapping(value = "/confirmSale.do")
    public String confirmSale(Sale sale)
    {
        System.out.println(sale);
        try {
            saleService.confirmSale(sale);
        } catch (Exception e) {
            e.printStackTrace();
            return "出库失败";
        }
        return "出库成功";
    }

    /**
     * 【根据用户ID查询日期内出货记录】
     * @param item
     * @return
     */
    @RequestMapping(value = "getSaleByDateAndCuId.do")
    public List<Sale> getSaleByDateAndCuId(OfIdAndDateItem item, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域请求问题
        System.out.println("获取客户出货记录");
        try {
            return saleService.getSaleByDateAndCuId(item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 【获得订单的售货记录】
     * @param id
     * @return
     */
    @RequestMapping(value = "/getSaledInfoByOrId.do")
    public List<Sale> getSaledInfoByOrId(Integer id)
    {
        return saleService.getSaledInfoByOrId(id);
    }

    /**
     * 【用户退货】
     * @return
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/backGoods.do")
    public String backGoods(Integer sale_id,Integer or_id,Integer back_num,String back_cause)
    {
        try{
            saleService.bakcGoods(sale_id,or_id,back_num,back_cause);
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return "退货成功";
    }
    /**
     * 【获得出货记录按出货时间排序】
     */
    @RequestMapping(value = "/getRecentSales.do")
    public List<Sale> getRecentSales()
    {
        return saleService.getRecentSales();
    }

    /**
     * 【设置结账情况】
     * @param id
     * @return
     */
    @RequestMapping(value = "/setPayment.do")
    public String setPayment(Integer id)
    {
        try{saleService.setPayment(id);}
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "结账成功";
    }

    /**
     * 【根据用户ID查询记录】
     */
    @RequestMapping(value = "/getSaleByCuId")
    public List<Sale> getSaleByCuId(Integer cuId)
    {
       return saleService.getSaleById(cuId);
    }

    /**
     * 【修改销售备注】
     */
    @RoleCheck(level = {1,3})
    @RequestMapping(value = "/updateOther.do")
    public String updateOther(String val,Integer key)
    {
        try {
            saleService.updateOther(key,val);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "更新成功";
    }
}
