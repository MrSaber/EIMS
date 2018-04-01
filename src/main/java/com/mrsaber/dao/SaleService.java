package com.mrsaber.dao;

import com.mrsaber.mapper.SaleMapper;
import com.mrsaber.model.OfIdAndDateItem;
import com.mrsaber.model.Sale;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZY on 2017/11/15.
 */
@Service
public class SaleService {
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private OrderService orderService;

    public void addSale(Sale sale)
    {
        try {
            //添加销售单
            saleMapper.addSale(sale);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmSale(Sale sale)
    {
        //更新仓库数据
        saleMapper.confirmSale(sale.getSale_id());
    }
    public List<Sale> getAllSaleUnCheck()
    {
        return saleMapper.getListSaleUnCheck();
    }
    public void delSaleById(Integer id)
    {
        saleMapper.delById(id);
    }

    /**
     * 根据客户ID获取出货记录
     * @param item
     * @return
     */
    public List<Sale> getListByDateAndCuId(OfIdAndDateItem item)
    {
        return saleMapper.getListByDateAndCuId(item);
    }
    /**
     * 根据订单号追踪用户
     */
    public List<Sale> getListByOrId(Integer id)
    {
        return saleMapper.getListByOrId(id);
    }
    /**
     *退货
     */
    public void bakcGoods(Integer sale_id,Integer or_id,Integer back_num,String back_cause)
    {
        saleMapper.backGoods(sale_id,back_num,back_cause);
    }
    /**
     * 按时间排列出货单
     */
    public List<Sale> getListByRecent()
    {
        return saleMapper.getListByRecent();
    }
    /**
     * 结账
     */
    public void setPayment(Sale sale)
    {
        saleMapper.setPayment(sale);
    }

    /**
     * 获得
     * @param cuId
     */
    public List<Sale> getListByCuId(Integer cuId) {
        return saleMapper.getListByCuId(cuId);
    }
    /**
     * 修改订单备注
     */
    public void updateOther(Integer key, String val)
    {
        saleMapper.updateOther(val,key);
    }

    /**
     * 获得具体订单
     * @param saleId
     * @return
     */
    public Sale getById(Integer saleId)
    {
        return saleMapper.getById(saleId);
    }

}
