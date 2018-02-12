package com.mrsaber.model;

public class ShopCart {
    private Integer car_id;
    private Integer car_su_id;
    private Integer car_su_number;
    private String car_other;
    //关联表信息
    private String su_name;
    private String su_storage;
    private String su_standard;
    private String su_orign;
    private String supplier_office;


    public String getSupplier_office() {
        return supplier_office;
    }

    public void setSupplier_office(String supplier_office) {
        this.supplier_office = supplier_office;
    }

    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
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

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getCar_su_id() {
        return car_su_id;
    }

    public void setCar_su_id(Integer car_su_id) {
        this.car_su_id = car_su_id;
    }

    public Integer getCar_su_number() {
        return car_su_number;
    }

    public void setCar_su_number(Integer car_su_number) {
        this.car_su_number = car_su_number;
    }

    public String getCar_other() {
        return car_other;
    }

    public void setCar_other(String car_other) {
        this.car_other = car_other;
    }
}
