package com.mrsaber.model;

/**
 * Created by ZY on 2017/11/15.
 */
public class UpdateItem {
    private Integer or_id;
    private Double cost_num;

    public Integer getOr_id() {
        return or_id;
    }

    public void setOr_id(Integer or_id) {
        this.or_id = or_id;
    }

    public Double getCost_num() {
        return cost_num;
    }

    public void setCost_num(Double cost_num) {
        this.cost_num = cost_num;
    }

    public UpdateItem(Integer or_id, Double cost_num) {
        this.or_id = or_id;
        this.cost_num = cost_num;
    }
}
