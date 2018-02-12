package com.mrsaber.model;

/**
 * Created by ZY on 2017/11/11.
 */
public class Customer {
    private Integer cu_id;
    private String cu_name;
    private Integer cu_office;
    private String cu_tel;
    private String cu_addr;
    private String cu_other;
    private Integer lab_id;
    //*********关联字段****************//
    private String of_name;
    private String cu_farther;
    public String getOf_name() {
        return of_name;
    }
    public void setOf_name(String of_name) {
        this.of_name = of_name;
    }
    //*********************************

    public String getCu_farther() {
        return cu_farther;
    }

    public void setCu_farther(String cu_farther) {
        this.cu_farther = cu_farther;
    }

    public Integer getLab_id() {
        return lab_id;
    }

    public void setLab_id(Integer lab_id) {
        this.lab_id = lab_id;
    }

    public Integer getCu_id() {
        return cu_id;
    }

    public void setCu_id(Integer cu_id) {
        this.cu_id = cu_id;
    }

    public String getCu_name() {
        return cu_name;
    }

    public void setCu_name(String cu_name) {
        this.cu_name = cu_name;
    }

    public Integer getCu_office() {
        return cu_office;
    }

    public void setCu_office(Integer cu_office) {
        this.cu_office = cu_office;
    }

    public String getCu_tel() {
        return cu_tel;
    }

    public void setCu_tel(String cu_tel) {
        this.cu_tel = cu_tel;
    }

    public String getCu_addr() {
        return cu_addr;
    }

    public void setCu_addr(String cu_addr) {
        this.cu_addr = cu_addr;
    }

    public String getCu_other() {
        return cu_other;
    }

    public void setCu_other(String cu_other) {
        this.cu_other = cu_other;
    }
}
