package com.mrsaber.model;

public class Lab {
    private Integer lab_id;
    private Integer lab_branch_id;
    private String lab_name;
    private String lab_other;

    public Integer getLab_id() {
        return lab_id;
    }

    public void setLab_id(Integer lab_id) {
        this.lab_id = lab_id;
    }

    public Integer getLab_branch_id() {
        return lab_branch_id;
    }

    public void setLab_branch_id(Integer lab_branch_id) {
        this.lab_branch_id = lab_branch_id;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getLab_other() {
        return lab_other;
    }

    public void setLab_other(String lab_other) {
        this.lab_other = lab_other;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "lab_id=" + lab_id +
                ", lab_branch_id=" + lab_branch_id +
                ", lab_name='" + lab_name + '\'' +
                ", lab_other='" + lab_other + '\'' +
                '}';
    }
}
