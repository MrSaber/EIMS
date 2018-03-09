package com.mrsaber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by ZY on 2017/11/9.
 */
public class Goods {
    private Integer su_id=0;
    private String su_name;
    private String su_No;
    private Integer su_supplier;
    private String su_orign;
    private String su_standard;
    private String su_storage;
    private Double su_cost;
    private Double su_listPrice;
    private Double su_price;

    private Integer su_warranty; //保质期
    private String su_other;
    //-----关联表查询属性-----//
    private String supplier_office;

    public String getSupplier_office() {
        return supplier_office;
    }

    public void setSupplier_office(String supplier_office) {
        this.supplier_office = supplier_office;
    }

    public String getSu_other() {
        return su_other;
    }

    public void setSu_other(String su_other) {
        this.su_other = su_other;
    }

    //************************
    public Integer getSu_warranty() {
        return su_warranty;
    }

    public void setSu_warranty(Integer su_warranty) {
        this.su_warranty = su_warranty;
    }

    public Integer getSu_id() {
        return su_id;
    }

    public void setSu_id(Integer su_id) {
        this.su_id = su_id;
    }

    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }

    public String getSu_No() {
        return su_No;
    }

    public void setSu_No(String su_No) {
        this.su_No = su_No;
    }

    public Integer getSu_supplier() {
        return su_supplier;
    }

    public void setSu_supplier(Integer su_supplier) {
        this.su_supplier = su_supplier;
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

    public Double getSu_cost() {
        return su_cost;
    }

    public void setSu_cost(Double su_cost) {
        this.su_cost = su_cost;
    }

    public Double getSu_listPrice() {
        return su_listPrice;
    }

    public void setSu_listPrice(Double su_listPrice) {
        this.su_listPrice = su_listPrice;
    }

    public Double getSu_price() {
        return su_price;
    }

    public void setSu_price(Double su_price) {
        this.su_price = su_price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "su_id=" + su_id +
                ", su_name='" + su_name + '\'' +
                ", su_No='" + su_No + '\'' +
                ", su_supplier=" + su_supplier +
                ", su_orign='" + su_orign + '\'' +
                ", su_standard='" + su_standard + '\'' +
                ", su_storage='" + su_storage + '\'' +
                ", su_cost=" + su_cost +
                ", su_listPrice=" + su_listPrice +
                ", su_price=" + su_price +
                '}';
    }
}
