package com.mrsaber.mapper;

import com.mrsaber.model.Customer;
import com.mrsaber.model.Office;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@Mapper
public interface OfficeMappper {
    @Select("SELECT ms_office.*,ms_customer.cu_name FROM gongxiao.ms_office LEFT OUTER JOIN gongxiao.ms_customer on(ms_office.of_principal=ms_customer.cu_id);")
     List<Office> getAllOffice();

    void addOffice(Office office);
    @Delete("DELETE FROM ms_office WHERE of_id = #{id}")
    void delOffice(Integer id);

}
