package com.mrsaber.mapper;

import com.mrsaber.model.Invoice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvoiceMapper {
    @Insert("INSERT INTO `gongxiao`.`invoice` (`in_sale_id`, `in_money`, `in_date`, `in_other`) VALUES (#{in_sale_id}, #{in_money}, #{in_date}, #{in_other});")
    public void addInvoice(Invoice invoice);

    @Select("SELECT * FROM invoice WHERE in_sale_id=#{saleId}")
    public List<Invoice> getInvoiceBySaleId(Integer saleId);

    @Delete("DELETE FROM invoice WHERE in_id=#{id}")
    void deleteById(Integer id);
}
