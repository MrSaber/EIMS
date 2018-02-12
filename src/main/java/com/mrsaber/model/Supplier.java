package com.mrsaber.model;

/**
 * Created by ZY on 2017/11/11.
 */
public class Supplier {
    private Integer supplier_id;
    private String supplier_name;
    private String supplier_office;
    private String supplier_tel;
    private String supplier_addr;
    private String supplier_other;
    private String supplier_bank;
    private String supplier_bankAccount;
    private String supplier_tax;
    private Double supplier_advance;
    private String supplier_type;
    private String supplier_level;
    private String supplier_fax;
    private String supplier_qq;
    private String supplier_weixin;
    private String supplier_mail;
    private String supplier_code;

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public String getSupplier_bank() {
        return supplier_bank;
    }

    public void setSupplier_bank(String supplier_bank) {
        this.supplier_bank = supplier_bank;
    }

    public String getSupplier_bankAccount() {
        return supplier_bankAccount;
    }

    public void setSupplier_bankAccount(String supplier_bankAccount) {
        this.supplier_bankAccount = supplier_bankAccount;
    }

    public String getSupplier_tax() {
        return supplier_tax;
    }

    public void setSupplier_tax(String supplier_tax) {
        this.supplier_tax = supplier_tax;
    }

    public Double getSupplier_advance() {
        return supplier_advance;
    }

    public void setSupplier_advance(Double supplier_advance) {
        this.supplier_advance = supplier_advance;
    }

    public String getSupplier_type() {
        return supplier_type;
    }

    public void setSupplier_type(String supplier_type) {
        this.supplier_type = supplier_type;
    }

    public String getSupplier_level() {
        return supplier_level;
    }

    public void setSupplier_level(String supplier_level) {
        this.supplier_level = supplier_level;
    }

    public String getSupplier_fax() {
        return supplier_fax;
    }

    public void setSupplier_fax(String supplier_fax) {
        this.supplier_fax = supplier_fax;
    }

    public String getSupplier_qq() {
        return supplier_qq;
    }

    public void setSupplier_qq(String supplier_qq) {
        this.supplier_qq = supplier_qq;
    }

    public String getSupplier_weixin() {
        return supplier_weixin;
    }

    public void setSupplier_weixin(String supplier_weixin) {
        this.supplier_weixin = supplier_weixin;
    }

    public String getSupplier_mail() {
        return supplier_mail;
    }

    public void setSupplier_mail(String supplier_mail) {
        this.supplier_mail = supplier_mail;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_office() {
        return supplier_office;
    }

    public void setSupplier_office(String supplier_office) {
        this.supplier_office = supplier_office;
    }

    public String getSupplier_tel() {
        return supplier_tel;
    }

    public void setSupplier_tel(String supplier_tel) {
        this.supplier_tel = supplier_tel;
    }

    public String getSupplier_addr() {
        return supplier_addr;
    }

    public void setSupplier_addr(String supplier_addr) {
        this.supplier_addr = supplier_addr;
    }

    public String getSupplier_other() {
        return supplier_other;
    }

    public void setSupplier_other(String supplier_other) {
        this.supplier_other = supplier_other;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", supplier_office='" + supplier_office + '\'' +
                ", supplier_tel='" + supplier_tel + '\'' +
                ", supplier_addr='" + supplier_addr + '\'' +
                ", supplier_other='" + supplier_other + '\'' +
                ", supplier_bank='" + supplier_bank + '\'' +
                ", supplier_bankAccount='" + supplier_bankAccount + '\'' +
                ", supplier_tax='" + supplier_tax + '\'' +
                ", supplier_advance=" + supplier_advance +
                ", supplier_type='" + supplier_type + '\'' +
                ", supplier_level='" + supplier_level + '\'' +
                ", supplier_fax='" + supplier_fax + '\'' +
                ", supplier_qq='" + supplier_qq + '\'' +
                ", supplier_weixin='" + supplier_weixin + '\'' +
                ", supplier_mail='" + supplier_mail + '\'' +
                '}';
    }
}
