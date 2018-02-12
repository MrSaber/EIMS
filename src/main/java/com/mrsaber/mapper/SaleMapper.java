package com.mrsaber.mapper;

import com.mrsaber.model.OfIdAndDateItem;
import com.mrsaber.model.Sale;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZY on 2017/11/15.
 */
@Mapper
public interface SaleMapper {
    void addSale(Sale sale);
    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_check`='1' WHERE `sale_id`=#{id};")
    void confirmSale(Integer id);
    @Select("SELECT ms_sale.*,ms_goods.su_name,ms_customer.cu_name FROM gongxiao.ms_sale,ms_goods,ms_customer WHERE sale_check=0 and sale_goods_id=su_id and sale_cu_id = cu_id;")
    List<Sale> getAllSaleUnCheck();
    @Delete("DELETE FROM `gongxiao`.`ms_sale` WHERE `sale_id`=#{id};")
    void delSaleById(Integer id);
    List<Sale> getSaleByDateAndCuId(OfIdAndDateItem item);
    @Select("SELECT ms_sale.sale_date,ms_sale.sale_price,ms_sale.sale_number,ms_customer.cu_name FROM gongxiao.ms_sale,ms_customer where sale_or_id=#{id} and sale_cu_id=cu_id;")
    List<Sale> getSaledInfoByOrId(Integer id);

    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_number`=`sale_number`-#{back_num}, `sale_other`=#{back_cause} WHERE `sale_id`=#{sale_id};")
    void backGoods(@Param("sale_id") Integer sale_id,@Param("back_num") Integer back_num,@Param("back_cause") String back_cause);


    List<Sale> getRecentSales();
    /**
     * 结款
     * @param id
     * @return
     */
    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_payment`=1 WHERE `sale_id`=#{id}; ")
    void setPayment(Integer id);

    /**
     * 修改备注
     */
    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_other`=#{val} WHERE `sale_id`=#{key};")
    void updateOther(@Param("val") String val, @Param("key") Integer key);

    List<Sale> getSaleByCuId(Integer cuId);
}
