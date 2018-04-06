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

    @Select("SELECT ms_sale.*, ms_goods.*, ms_supplier.*,ms_customer.cu_name FROM gongxiao.ms_sale, ms_goods, ms_customer, ms_supplier WHERE sale_check = 0 AND sale_goods_id = su_id AND sale_cu_id = cu_id AND su_supplier = supplier_id;")
    List<Sale> getListSaleUnCheck();

    List<Sale> getListByDateAndCuId(OfIdAndDateItem item);

    @Select("SELECT ms_sale.sale_date,ms_sale.sale_price,ms_sale.sale_number,ms_customer.cu_name FROM gongxiao.ms_sale,ms_customer where sale_or_id=#{id} and sale_cu_id=cu_id;")
    List<Sale> getListByOrId(Integer id);

    /**
     * 根据顾客ID获取购买信息
     * @param cuId
     * @return
     */
    List<Sale> getListByCuId(Integer cuId);

    /**
     * 获取订单信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM ms_sale WHERE sale_id = #{id}")
    Sale getById(Integer id);



    /**
     * 删除订单信息
     * @param id
     */
    @Delete("DELETE FROM `gongxiao`.`ms_sale` WHERE `sale_id`=#{id};")
    void delById(Integer id);




    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_number`=`sale_number`-#{back_num}, `sale_other`=#{back_cause} WHERE `sale_id`=#{sale_id};")
    void backGoods(@Param("sale_id") Integer sale_id,@Param("back_num") Integer back_num,@Param("back_cause") String back_cause);

    List<Sale> getListByRecent();

    @Select("SELECT COUNT(*) FROM ms_sale WHERE sale_check =1;")
    Integer getCount();


    @Select("SELECT ms_sale.*,cu_name,ms_goods.*  FROM gongxiao.ms_sale,gongxiao.ms_customer,gongxiao.ms_goods WHERE sale_cu_id=cu_id and sale_goods_id=su_id and sale_check =1 limit #{rows} offset #{offset};")
    List<Sale> getListByPage(@Param("rows")Integer rows,@Param("offset") Integer offset);

    /**
     * 结款
     * @param sale
     * @return
     */
    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_payment`=1, `sale_paydate`=#{sale_paydate} ,`sale_commit`=#{sale_commit} WHERE `sale_id`=#{sale_id};")
    void setPayment(Sale sale);
    /**
     * 修改备注
     */
    @Update("UPDATE `gongxiao`.`ms_sale` SET `sale_other`=#{val} WHERE `sale_id`=#{key};")
    void updateOther(@Param("val") String val, @Param("key") Integer key);
}
