package com.mrsaber.model;

public class Branch {
    private Integer br_id;
    private Integer br_office_id;
    private String br_name;
    private String br_other;

    public String toString() {
        return "Branch{" +
                "br_id=" + br_id +
                ", br_office_id=" + br_office_id +
                ", br_name='" + br_name + '\'' +
                ", br_other='" + br_other + '\'' +
                '}';
    }

    public Integer getBr_id() {
        return br_id;
    }

    public void setBr_id(Integer br_id) {
        this.br_id = br_id;
    }

    public Integer getBr_office_id() {
        return br_office_id;
    }

    public void setBr_office_id(Integer br_office_id) {
        this.br_office_id = br_office_id;
    }

    public String getBr_name() {
        return br_name;
    }

    public void setBr_name(String br_name) {
        this.br_name = br_name;
    }

    public String getBr_other() {
        return br_other;
    }

    public void setBr_other(String br_other) {
        this.br_other = br_other;
    }
}
