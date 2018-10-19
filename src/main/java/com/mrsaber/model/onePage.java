package com.mrsaber.model;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class onePage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long total;
    private List<T> rows;

    public onePage() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "onePage{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}