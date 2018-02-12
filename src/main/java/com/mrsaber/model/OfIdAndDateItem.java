package com.mrsaber.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by ZY on 2017/11/16.
 */
public class OfIdAndDateItem {
    private Integer key_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;

    public Integer getKey_id() {
        return key_id;
    }

    public void setKey_id(Integer of_id) {
        this.key_id = of_id;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
