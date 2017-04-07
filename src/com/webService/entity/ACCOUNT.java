package com.webService.entity;

public class ACCOUNT {
    private String account_id;
    private String cust_id;
    private String account_name;
    private String lan_id;
    private String phone;
    private String status_cd;
    public String getAccount_id() {
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public String getCust_id() {
        return cust_id;
    }
    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }
    public String getAccount_name() {
        return account_name;
    }
    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getStatus_cd() {
        return status_cd;
    }
    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd;
    }
    public String getLan_id() {
        return lan_id;
    }
    public void setLan_id(String lan_id) {
        this.lan_id = lan_id;
    }
    
}
