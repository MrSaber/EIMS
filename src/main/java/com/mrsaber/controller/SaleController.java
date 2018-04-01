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
            return e.getMessage();
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
    @RoleCheck(level = {3})
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
     * 【用户退货】
     * @return
     */
    @RoleCheck(level = {3})
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
    @RequestMapping(value = "/getListByRecent.do")
    public List<Sale> getListByRecent()
    {
        return saleService.getListByRecent();
    }

    /**
     * 【获得订单的售货记录】
     */
    @RequestMapping(value = "/getListByOrId.do")
    public List<Sale> getListByOrId(Integer id)
    {
        return saleService.getListByOrId(id);
    }

    /**
     * 【根据用户ID查询记录】
     */
    @RequestMapping(value = "/getListByCuId.do")
    public List<Sale> getListByCuId(Integer cuId)
    {
        return saleService.getListByCuId(cuId);
    }

    /**
     * 【根据用户ID查询日期内出货记录】
     * @param item
     * @return
     */
    @RequestMapping(value = "/getListByDateAndCuId.do")
    public List<Sale> getListByDateAndCuId(OfIdAndDateItem item)
    {
            return saleService.getListByDateAndCuId(item);
    }





    /**
     * 【设置结账情况】
     * @param
     * @return
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/setPayment.do")
    public String setPayment(Sale sale)
    {
        try{
            System.out.println(sale.getSale_id()+sale.getSale_commit()+sale.getSale_paydate());
            saleService.setPayment(sale);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        return "结账成功";
    }

    /**
     * 【修改销售备注】
     */
    @RoleCheck(level = {3})
    @RequestMapping(value = "/updateOther.do")
    public String setOther(String val,Integer key)
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
