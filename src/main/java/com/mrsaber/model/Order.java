package com.mrsaber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by ZY on 2017/11/12.
 */
public class Order {
    private Integer or_id;
    private Integer or_goods_id;
    private Integer or_supplier_id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date or_date;//日期
    private Double or_price;//价格
    private Double or_number;//数量
    private Double or_total;//总结额
    private Integer or_invoice;//是否有订单
    private String or_other; //备注
    private Integer or_check=0; //状态 0 表示订货状态
    private Integer or_initial; //订货量
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date or_deaddate;
    private Integer or_alarm;
    private Integer or_payment;
    //-----关联表查询属性-----//
    private Integer su_id;
    private String su_name; //货品名称
    private String su_No; //货品名称
    private String su_orign;
    private String su_standard;
    private String su_storage;
    private Double su_listPrice;

    public Double getSu_listPrice() {
        return su_listPrice;
    }

    public void setSu_listPrice(Double su_listPrice) {
        this.su_listPrice = su_listPrice;
    }

    public String getSu_No() {
        return su_No;
    }

    public void setSu_No(String su_No) {
        this.su_No = su_No;
    }

    public Integer getSu_id() {
        return su_id;
    }

    public void setSu_id(Integer su_id) {
        this.su_id = su_id;
    }

    public Date getOr_deaddate() {
        return or_deaddate;
    }

    public void setOr_deaddate(Date or_deaddate) {
        this.or_deaddate = or_deaddate;
    }

    public Integer getOr_alarm() {
        return or_alarm;
    }

    public void setOr_alarm(Integer or_alarm) {
        this.or_alarm = or_alarm;
    }

    public Integer getOr_payment() {
        return or_payment;
    }

    public void setOr_payment(Integer or_payment) {
        this.or_payment = or_payment;
    }

    public String getSu_orign() {
        return su_orign;
    }

    public void setSu_orign(String su_orign) {
        this.su_orign = su_orign;
    }

    public String getSu_standard() {
        return su_standard;
    }

    public void setSu_standard(String su_standard) {
        this.su_standard = su_standard;
    }

    public String getSu_storage() {
        return su_storage;
    }

    public void setSu_storage(String su_storage) {
        this.su_storage = su_storage;
    }

    private String supplier_office;
    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }

    public String getSupplier_office() {
        return supplier_office;
    }

    public void setSupplier_office(String supplier_office) {
        this.supplier_office = supplier_office;
    }
    //***********************//


    public Integer getOr_initial() {
        return or_initial;
    }

    public void setOr_initial(Integer or_initial) {
        this.or_initial = or_initial;
    }

    public String getOr_other() {
        return or_other;
    }

    public void setOr_other(String or_other) {
        this.or_other = or_other;
    }

    public Integer getOr_check() {
        return or_check;
    }

    public void setOr_check(Integer or_check) {
        this.or_check = or_check;
    }

    public Integer getOr_invoice() {
        return or_invoice;
    }

    public void setOr_invoice(Integer or_invoice) {
        this.or_invoice = or_invoice;
    }

    public Integer getOr_id() {
        return or_id;
    }

    public void setOr_id(Integer or_id) {
        this.or_id = or_id;
    }

    public Integer getOr_goods_id() {
        return or_goods_id;
    }

    public void setOr_goods_id(Integer or_goods_id) {
        this.or_goods_id = or_goods_id;
    }

    public Integer getOr_supplier_id() {
        return or_supplier_id;
    }

    public void setOr_supplier_id(Integer or_supplier_id) {
        this.or_supplier_id = or_supplier_id;
    }

    public Date getOr_date() {
        return or_date;
    }

    public void setOr_date(Date or_date) {
        this.or_date = or_date;
    }

    public Double getOr_price() {
        return or_price;
    }

    public void setOr_price(Double or_price) {
        this.or_price = or_price;
    }

    public Double getOr_number() {
        return or_number;
    }

    public void setOr_number(Double or_number) {
        this.or_number = or_number;
    }

    public Double getOr_total() {
        return or_total;
    }

    public void setOr_total(Double or_total) {
        this.or_total = or_total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "or_id=" + or_id +
                ", or_goods_id=" + or_goods_id +
                ", or_supplier_id=" + or_supplier_id +
                ", or_date=" + or_date +
                ", or_price=" + or_price +
                ", or_number=" + or_number +
                ", or_total=" + or_total +
                ", or_invoice=" + or_invoice +
                ", or_other='" + or_other + '\'' +
                ", or_check=" + or_check +
                ", or_initial=" + or_initial +
                ", or_deaddate=" + or_deaddate +
                ", or_alarm=" + or_alarm +
                ", or_payment=" + or_payment +
                ", su_name='" + su_name + '\'' +
                ", su_orgin='" + su_orign + '\'' +
                ", su_standard='" + su_standard + '\'' +
                ", su_storage='" + su_storage + '\'' +
                ", supplier_office='" + supplier_office + '\'' +
                '}';
    }
}
