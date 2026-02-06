package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.BillStatus;
import com.example.projects.resturentManagementSystemAssignment.models.constants.PaymentMode;

import java.time.LocalDateTime;

public class Bill extends BaseModel {
    private CustomerSession customerSession;
    private double amount;
    private BillStatus billStatus;
    private PaymentMode paymentMode;
    private LocalDateTime generatedDate;

    public Bill() {
    }

    public Bill(CustomerSession customerSession, double amount, BillStatus billStatus, PaymentMode paymentMode, LocalDateTime generatedDate) {
        this.customerSession = customerSession;
        this.amount = amount;
        this.billStatus = billStatus;
        this.paymentMode = paymentMode;
        this.generatedDate = generatedDate;
    }

    public CustomerSession getCustomerSession() {
        return customerSession;
    }

    public void setCustomerSession(CustomerSession customerSession) {
        this.customerSession = customerSession;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }
}
