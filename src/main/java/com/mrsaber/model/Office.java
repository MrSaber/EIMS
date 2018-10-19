package com.mrsaber.model;

/**
 * Created by ZY on 2017/11/11.
 */
public class Office {
    private Integer of_id;
    private Integer of_principal;
    private String of_name;
    private String of_addr;
    private String of_other;
    //************关联表查询*************
    private String cu_name; //负责人信息

    public String getCu_name() {
        return cu_name;
    }

    public void setCu_name(String cu_name) {
        this.cu_name = cu_name;
    }

    //**********************************
    public Integer getOf_id() {
        return of_id;
    }

    public void setOf_id(Integer of_id) {
        this.of_id = of_id;
    }

    public Integer getOf_principal() {
        return of_principal;
    }

    public void setOf_principal(Integer of_principal) {
        this.of_principal = of_principal;
    }

    public String getOf_name() {
        return of_name;
    }

    public void setOf_name(String of_name) {
        this.of_name = of_name;
    }

    public String getOf_addr() {
        return of_addr;
    }

    public void setOf_addr(String of_addr) {
        this.of_addr = of_addr;
    }

    public String getOf_other() {
        return of_other;
    }

    public void setOf_other(String of_other) {
        this.of_other = of_other;
    }

    @Override
    public String toString() {
        return "Office{" +
                "of_id=" + of_id +
                ", of_principal=" + of_principal +
                ", of_name='" + of_name + '\'' +
                ", of_addr='" + of_addr + '\'' +
                ", of_other='" + of_other + '\'' +
                '}';
    }
}
