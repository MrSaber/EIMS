package com.mrsaber.model;

import java.util.List;

/**
 * Created by ZY on 2017/11/9.
 */
public class GoodsItem {
    private Integer code;
    private String msg;
    private Integer count;
    private List<Goods> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Goods> getData() {
        return data;
    }

    public void setData(List<Goods> data) {
        this.data = data;
    }
}
