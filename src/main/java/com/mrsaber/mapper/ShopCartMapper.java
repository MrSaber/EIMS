package com.mrsaber.mapper;

import com.mrsaber.model.ShopCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopCartMapper {
    @Select("SELECT ms_shopcar.*,ms_goods.*,supplier_office FROM gongxiao.ms_shopcar,ms_goods,ms_supplier WHERE ms_shopcar.car_su_id=ms_goods.su_id and ms_supplier.supplier_id=ms_goods.su_supplier;")
    List<ShopCart> getCuItems();

    @Insert("INSERT INTO `gongxiao`.`ms_shopcar` (`car_su_id`, `car_su_number`, `car_other`) VALUES (#{car_su_id}, #{car_su_number},#{car_other});")
    void addItem(ShopCart shopCart);

    @Delete("DELETE FROM ms_shopcar WHERE car_id =#{id}")
    void deleteItemById(Integer id);

    @Delete("DELETE FROM ms_shopcar;")
    void delteAll();
}
