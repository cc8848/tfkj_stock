package com.webService.entity;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerType;
    private String customerLan_ID;
    private String status_cd;
    
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public String getCustomerLan_ID() {
        return customerLan_ID;
    }
    public void setCustomerLan_ID(String customerLan_ID) {
        this.customerLan_ID = customerLan_ID;
    }
    public String getStatus_cd() {
        return status_cd;
    }
    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd;
    }
}
