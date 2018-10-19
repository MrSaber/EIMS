package com.mrsaber.mapper;

import com.mrsaber.model.Customer;
import com.mrsaber.model.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by ZY on 2017/11/11.
 */
@Mapper
public interface CustomerMapper {
    @Select("SELECT ms_customer.*,ms_office.of_name FROM gongxiao.ms_customer LEFT OUTER JOIN gongxiao.ms_office ON(ms_customer.cu_office=ms_office.of_id);")
    List<Customer> getAllCustomer();

    void addCustomer(Customer customer);

    @Delete("DELETE   FROM gongxiao.ms_customer WHERE cu_id=#{id}")
    void delCustomer(Integer id);

    @Update("UPDATE `gongxiao`.`ms_customer` SET `cu_name`=#{cu_name}, `cu_tel`=#{cu_tel}, `cu_addr`=#{cu_addr}, `cu_other`=#{cu_other} WHERE `cu_id`=#{cu_id};")
    void update(Customer customer);

    @Select("SELECT * FROM gongxiao.ms_customer WHERE cu_office=#{id} and cu_farther=-1")
    List<Customer> getCustomerByLabId(Integer id);

    @Select("SELECT * FROM gongxiao.ms_customer WHERE cu_farther=#{id}")
    List<Customer> getCustomerByFarId(Integer id);

    @Select("SELECT * FROM gongxiao.ms_customer WHERE cu_id=#{id}")
    Customer getCustomerById(Integer id);

    @Select("SELECT * FROM ms_customer WHERE cu_name like #{like};")
    List<Customer> getListByLikeName(String like);
}
