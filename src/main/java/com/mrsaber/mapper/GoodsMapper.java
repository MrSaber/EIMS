package com.mrsaber.mapper;

import com.mrsaber.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZY on 2017/11/9.
 */
@Mapper
public interface GoodsMapper {
    @Select("SELECT ms_goods.*,ms_supplier.supplier_office FROM gongxiao.ms_goods LEFT OUTER JOIN gongxiao.ms_supplier ON (su_supplier=supplier_id);")
    List<Goods> getAllGoods();

    void addGoods(Goods goods);

    @Update("UPDATE ms_goods SET su_warranty=1 WHERE su_id=#{id};")
    void delGoodsById(Integer id);

    @Select("SELECT ms_goods.*,ms_supplier.supplier_office FROM gongxiao.ms_goods,gongxiao.ms_supplier WHERE (su_supplier=supplier_id and su_name like #{like});")
    List<Goods> getListByLikeName(String like);

    @Select("SELECT ms_goods.*,ms_supplier.supplier_office FROM gongxiao.ms_goods,gongxiao.ms_supplier WHERE (su_supplier=supplier_id and su_No like #{like});")
    List<Goods> getListByLikeNo(String like);

    @Select("SELECT * FROM gongxiao.ms_goods WHERE su_id=#{id};")
    Goods getGoodsById(Integer id);

    @Update("UPDATE `gongxiao`.`ms_goods` SET `su_name`=#{su_name}, `su_No`=#{su_No}, `su_orign`=#{su_orign}, `su_standard`=#{su_standard}, `su_storage`=#{su_storage},`su_listPrice`=#{su_listPrice}, `su_other`=#{su_other}  WHERE `su_id`=#{su_id};")
    void updateById(Goods goods);

    @Select("SELECT COUNT(*) FROM gongxiao.ms_goods")
    Integer getCount();

    @Select("SELECT ms_goods.*,ms_supplier.supplier_office FROM ms_goods LEFT OUTER JOIN ms_supplier ON (su_supplier=supplier_id) WHERE su_warranty is NULL LIMIT #{rows} OFFSET #{offset}")
    List<Goods> getListByPage(@Param("rows") Integer rows, @Param("offset") Integer offset);
}