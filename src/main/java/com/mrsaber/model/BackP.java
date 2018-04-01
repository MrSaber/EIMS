package com.mrsaber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BackP {
    private Integer bp_id;
    private Integer bp_or_id;
    private Integer bp_number;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date bp_date;
    private String bp_other;
    private String bp_su_id;

    public String getBp_su_id() {
        return bp_su_id;
    }

    public void setBp_su_id(String bp_su_id) {
        this.bp_su_id = bp_su_id;
    }

    public Integer getBp_id() {
        return bp_id;
    }

    public void setBp_id(Integer bp_id) {
        this.bp_id = bp_id;
    }

    public Integer getBp_or_id() {
        return bp_or_id;
    }

    public void setBp_or_id(Integer bp_or_id) {
        this.bp_or_id = bp_or_id;
    }

    public Integer getBp_number() {
        return bp_number;
    }

    public void setBp_number(Integer bp_number) {
        this.bp_number = bp_number;
    }

    public Date getBp_date() {
        return bp_date;
    }

    public void setBp_date(Date bp_date) {
        this.bp_date = bp_date;
    }

    public String getBp_other() {
        return bp_other;
    }

    public void setBp_other(String bp_other) {
        this.bp_other = bp_other;
    }
}
