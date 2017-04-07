package com.webService.entity;

public class Payment {
    private String paymentId;
    private String accountId;
    private String payMethodId;
    private String payBankId;
    private String paymentAccount;
    private String paymentAccountName;
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getPayMethodId() {
        return payMethodId;
    }
    public void setPayMethodId(String payMethodId) {
        this.payMethodId = payMethodId;
    }
    public String getPayBankId() {
        return payBankId;
    }
    public void setPayBankId(String payBankId) {
        this.payBankId = payBankId;
    }
    public String getPaymentAccount() {
        return paymentAccount;
    }
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
    public String getPaymentAccountName() {
        return paymentAccountName;
    }
    public void setPaymentAccountName(String paymentAccountName) {
        this.paymentAccountName = paymentAccountName;
    }
    
}
