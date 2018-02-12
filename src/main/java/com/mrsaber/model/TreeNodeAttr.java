package com.mrsaber.model;

public class TreeNodeAttr {
    private Integer type; //单位——0；学院——1；科室——2；
    private Integer targetVal;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTargetVal() {
        return targetVal;
    }

    public void setTargetVal(Integer targetVal) {
        this.targetVal = targetVal;
    }
}
