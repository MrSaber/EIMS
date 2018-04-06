package com.mrsaber.mapper;

import com.mrsaber.model.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@Mapper
public interface SupplierMapper {
    @Select("SELECT * FROM gongxiao.ms_supplier;")
    List<Supplier> getAllSupplierInfo();
    void addSupplier(Supplier supplier);
    @Delete("DELETE FROM gongxiao.ms_supplier WHERE supplier_id=#{id};")
    void delSupplierById(Integer id);
    @Select("SELECT * FROM gongxiao.ms_supplier WHERE supplier_id=#{id};")
    Supplier getSupplierById(Integer id);
    @Update("UPDATE `gongxiao`.`ms_supplier` SET `supplier_name`=#{supplier_name}, `supplier_office`=#{supplier_office}, `supplier_tel`=#{supplier_tel}, `supplier_addr`=#{supplier_addr}, `supplier_other`=#{supplier_other}, `supplier_bank`=#{supplier_bank}, `supplier_bankAccount`=#{supplier_bankAccount}, `supplier_tax`=#{supplier_tax}, `supplier_advance`=#{supplier_advance}, `supplier_type`=#{supplier_type}, `supplier_level`=#{supplier_level}, `supplier_fax`=#{supplier_fax}, `supplier_qq`=#{supplier_qq}, `supplier_weixin`=#{supplier_weixin}, `supplier_mail`=#{supplier_mail} WHERE `supplier_id`=#{supplier_id};")
     void updateSu(Supplier supplier);

    @Select("SELECT * FROM gongxiao.ms_supplier WHERE supplier_office like #{supplier_office};")
    List<Supplier> getListByLikeName(String supplier_office);

    @Select("SELECT COUNT(*) FROM gongxiao.ms_supplier")
    Integer getCount();

    @Select("SELECT * FROM gongxiao.ms_supplier LIMIT #{rows} OFFSET #{offset}")
    List<Supplier> getListByPage(@Param("rows")Integer rows, @Param("offset") Integer offset);
}
