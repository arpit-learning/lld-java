package com.example.projects.parkingLotSystemAssignment.models;

import com.example.projects.parkingLotSystemAssignment.models.constants.BillStatus;
import com.example.projects.parkingLotSystemAssignment.models.constants.PaymentGatewayType;
import com.example.projects.parkingLotSystemAssignment.models.constants.PaymentMode;

import java.time.LocalDateTime;

public class Bill extends BaseModel {
    private Ticket ticket;
    private LocalDateTime exitTime;
    private Gate exitGate;
    private PaymentMode paymentMode;
    private PaymentGatewayType paymentGatewayType;
    private BillStatus billStatus;

    public Bill() {
    }

    public Bill(Ticket ticket, LocalDateTime exitTime, Gate exitGate, PaymentMode paymentMode, PaymentGatewayType paymentGatewayType, BillStatus billStatus) {
        this.ticket = ticket;
        this.exitTime = exitTime;
        this.exitGate = exitGate;
        this.paymentMode = paymentMode;
        this.paymentGatewayType = paymentGatewayType;
        this.billStatus = billStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentGatewayType getPaymentGatewayType() {
        return paymentGatewayType;
    }

    public void setPaymentGatewayType(PaymentGatewayType paymentGatewayType) {
        this.paymentGatewayType = paymentGatewayType;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
