package com.mrsaber.model;

public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_other;
    private Integer user_role;


    public Integer getUser_role() {
        return user_role;
    }

    public void setUser_role(Integer user_role) {
        this.user_role = user_role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_other() {
        return user_other;
    }

    public void setUser_other(String user_other) {
        this.user_other = user_other;
    }
}
