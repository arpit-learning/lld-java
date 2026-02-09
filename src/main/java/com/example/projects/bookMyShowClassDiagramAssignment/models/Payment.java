package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.PaymentMode;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.PaymentStatus;

public class Payment extends BaseModel {
    private Booking booking;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public Payment() {
    }

    public Payment(Booking booking, PaymentStatus paymentStatus, PaymentMode paymentMode) {
        this.booking = booking;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
