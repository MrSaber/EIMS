package com.mrsaber.mapper;

import com.mrsaber.model.OfIdAndDateItem;
import com.mrsaber.model.Order;
import com.mrsaber.model.Statistics;
import com.mrsaber.model.UpdateItem;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by ZY on 2017/11/12.
 */
@Mapper
public interface OrderMapper {
    /**
     * 添加库存
     *
     * @param order
     */
    void addOrder(Order order);

    /**
     * 获得所有库存
     *
     * @return
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods WHERE or_supplier_id=supplier_id and or_goods_id=su_id and or_check=3;")
    List<Order> getList();


    @Select("SELECT COUNT(*) FROM ms_sale WHERE sale_check =1;")
    Integer getCount();

    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods WHERE or_supplier_id=supplier_id and or_goods_id=su_id and or_check=3 limit #{rows} offset #{offset};;")
    List<Order> getListByPage(@Param("rows") Integer rows, @Param("offset") Integer offset);


    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods WHERE or_supplier_id=supplier_id and or_goods_id=su_id and or_check=3 LIMIT #{row} OFFSET #{page};")
    List<Order> getListByPageAndRow(@Param("row") Integer row, @Param("page") Integer page);

    /**
     * 获得公司进货记录
     */
    @Select("SELECT * FROM gongxiao.repertory WHERE or_id=#{id}")
    Order getById(Integer id);

    /**
     * 获得库存物品信息
     *
     * @param val
     * @return
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,ms_goods WHERE ms_order.or_goods_id =#{val} and or_goods_id=su_id and or_supplier_id=supplier_id and or_check='3';")
    List<Order> getGoodsInfoInBound(Integer val);

    /**
     * 设置发票状况
     *
     * @param key
     */
    @Update("UPDATE `gongxiao`.`ms_order` SET `or_invoice`=#{value} WHERE `or_id`=#{key};")
    void setInvoice(@Param("key") Integer key, @Param("value") Integer value);

    /**
     * 结款
     *
     * @param id
     * @return
     */
    @Update("UPDATE `gongxiao`.`ms_order` SET `or_payment`=6 WHERE `or_id`=#{id};")
    void setPayment(Integer id);

    /**
     * 获得待审核进货信息
     *
     * @param check
     * @return
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods WHERE or_supplier_id=supplier_id and or_goods_id=su_id and ms_order.or_check=#{check};")
    List<Order> getOrderWhereCheck(Integer check);

    /**
     * 删除库存
     *
     * @param id
     */
    @Delete("DELETE FROM `gongxiao`.`ms_order` WHERE `or_id`=#{id};")
    void deleteOrderById(Integer id);

    /**
     * 获得库存状态
     *
     * @return
     */
    @Select("select su_name,SUM(or_number) as su_sum from repertory group by su_name;")
    List<Statistics> getStatistics();

    /**
     * 查找相似物品的库存信息
     *
     * @param like
     * @return
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods where ms_goods.su_name like #{like} and or_supplier_id=supplier_id and or_check='3' and or_goods_id = su_id")
    List<Order> getLikeOrderInBound(String like);

    /**
     * 查找货号的库存信息
     *
     * @param like
     * @return
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods where ms_goods.su_No like #{like} and or_supplier_id=supplier_id and or_check='3' and or_goods_id = su_id")
    List<Order> getListByNo(String like);


    void updateOrderNumInBound(UpdateItem updateItem);

    /**
     * 审核入库
     */
    @Update("UPDATE `gongxiao`.`ms_order` SET `or_check`= 3 WHERE `or_id`=#{id};")
    void orderInBound(Integer id);

    /**
     * 刷新库存
     */
    void refreshOrderInBound();

    /**
     * 根据日期和供货商获得库存信息
     *
     * @param item
     * @return
     */
    List<Order> getOrderByDateAndSupplierId(OfIdAndDateItem item);

    /**
     * 获得仓库预警库存
     *
     * @return
     */
    @Select("SELECT * FROM gongxiao.repertory WHERE or_number<=or_alarm;")
    List<Order> getBoundAlarm();

    /**
     * 获得仓库预期
     * 只显示库存大于0的，小鱼0的不需要显示！
     *
     * @param time
     * @return
     */
    @Select("SELECT * FROM gongxiao.repertory WHERE or_deaddate<=#{s} and or_number >0;")
    List<Order> getListByDead(Date time);

    /**
     * 重设预警值
     *
     * @param val
     * @param key
     */
    @Update("UPDATE `gongxiao`.`ms_order` SET `or_alarm`=#{val} WHERE `or_id`=#{key};")
    void resetAlarm(@Param("val") Integer val, @Param("key") Integer key);

    /**
     * 根据公司ID获得库存信息
     */
    @Select("SELECT ms_order.*,ms_supplier.supplier_office,ms_goods.* FROM gongxiao.ms_order,gongxiao.ms_supplier,gongxiao.ms_goods where or_supplier_id=supplier_id and or_check='3' and or_goods_id = su_id and supplier_id=#{id}")
    List<Order> getListBySupId(Integer id);

    /**
     * 获得公司库存金额
     *
     * @return
     */
    @Select("SELECT sum(or_price*or_number) FROM gongxiao.ms_order WHERE or_check =3;")
    Double getAmount();

    /**
     * 修改备注
     */
    @Update("UPDATE `gongxiao`.`ms_order` SET `or_other`=#{val} WHERE `or_id`=#{key};")
    void updateOther(@Param("val") String val, @Param("key") Integer key);
}