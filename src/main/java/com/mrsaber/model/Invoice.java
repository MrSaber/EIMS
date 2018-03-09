package com.mrsaber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Invoice {
    private Integer in_id;
    private Integer in_sale_id;
    private Double in_money;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date in_date;
    private String in_other;
    public Integer getIn_id() {
        return in_id;
    }
    public void setIn_id(Integer in_id) {
        this.in_id = in_id;
    }

    public Integer getIn_sale_id() {
        return in_sale_id;
    }

    public void setIn_sale_id(Integer in_sale_id) {
        this.in_sale_id = in_sale_id;
    }

    public Double getIn_money() {
        return in_money;
    }

    public void setIn_money(Double in_money) {
        this.in_money = in_money;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public String getIn_other() {
        return in_other;
    }

    public void setIn_other(String in_other) {
        this.in_other = in_other;
    }
}
