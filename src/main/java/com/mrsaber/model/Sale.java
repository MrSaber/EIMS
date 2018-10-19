package com.mrsaber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Sale {
    private Integer sale_id;
    private Integer sale_goods_id;
    private Integer sale_cu_id;
    private Integer sale_or_id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date sale_date;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date sale_paydate;

    private Double sale_price;
    private Double sale_number;
    private Double sale_count;
    private String sale_other;
    private Integer sale_invoice; //是否开发票
    private Integer sale_payment; //付款状况
    private String sale_commit;//

    //******关联表字段**********
    private String cu_name;
    private String su_name;
    private String su_storage;
    private String su_standard;
    private String su_orign;
    private String su_No;
    private String of_name;
    private String supplier_office;


    public String getSale_commit() {
        return sale_commit;
    }

    public void setSale_commit(String sale_commit) {
        this.sale_commit = sale_commit;
    }

    public Date getSale_paydate() {
        return sale_paydate;
    }

    public void setSale_paydate(Date sale_paydate) {
        this.sale_paydate = sale_paydate;
    }

    public String getSu_No() {
        return su_No;
    }

    public void setSu_No(String su_No) {
        this.su_No = su_No;
    }

    public Integer getSale_payment() {
        return sale_payment;
    }

    public void setSale_payment(Integer sale_payment) {
        this.sale_payment = sale_payment;
    }

    public String getSu_storage() {
        return su_storage;
    }

    public void setSu_storage(String su_storage) {
        this.su_storage = su_storage;
    }

    public String getSu_standard() {
        return su_standard;
    }

    public void setSu_standard(String su_standard) {
        this.su_standard = su_standard;
    }

    public String getSu_orign() {
        return su_orign;
    }

    public void setSu_orign(String su_orign) {
        this.su_orign = su_orign;
    }

    public String getSupplier_office() {
        return supplier_office;
    }

    public void setSupplier_office(String supplier_office) {
        this.supplier_office = supplier_office;
    }

    public String getOf_name() {
        return of_name;
    }

    public void setOf_name(String of_name) {
        this.of_name = of_name;
    }

    public String getCu_name() {
        return cu_name;
    }

    public void setCu_name(String cu_name) {
        this.cu_name = cu_name;
    }

    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }

    //************************//
    public Integer getSale_or_id() {
        return sale_or_id;
    }

    public void setSale_or_id(Integer sale_or_id) {
        this.sale_or_id = sale_or_id;
    }

    public Integer getSale_invoice() {
        return sale_invoice;
    }

    public void setSale_invoice(Integer sale_invoice) {
        this.sale_invoice = sale_invoice;
    }

    public Integer getSale_cu_id() {
        return sale_cu_id;
    }

    public void setSale_cu_id(Integer sale_cu_id) {
        this.sale_cu_id = sale_cu_id;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Integer getSale_goods_id() {
        return sale_goods_id;
    }

    public void setSale_goods_id(Integer sale_goods_id) {
        this.sale_goods_id = sale_goods_id;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public Double getSale_price() {
        return sale_price;
    }

    public void setSale_price(Double sale_price) {
        this.sale_price = sale_price;
    }

    public Double getSale_number() {
        return sale_number;
    }

    public void setSale_number(Double sale_number) {
        this.sale_number = sale_number;
    }

    public Double getSale_count() {
        return sale_count;
    }

    public void setSale_count(Double sale_count) {
        this.sale_count = sale_count;
    }

    public String getSale_other() {
        return sale_other;
    }

    public void setSale_other(String sale_other) {
        this.sale_other = sale_other;
    }
}
