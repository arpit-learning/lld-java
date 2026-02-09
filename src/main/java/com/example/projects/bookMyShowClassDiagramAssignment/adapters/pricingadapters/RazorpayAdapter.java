package com.example.projects.bookMyShowClassDiagramAssignment.adapters.pricingadapters;

import com.example.projects.bookMyShowClassDiagramAssignment.models.Booking;
import com.example.projects.bookMyShowClassDiagramAssignment.models.Payment;
import com.example.projects.bookMyShowClassDiagramAssignment.models.RazorpayApi;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.PaymentMode;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.PaymentStatus;

public class RazorpayAdapter implements PaymentAdapter {
    private RazorpayApi razorpayApi;

    public RazorpayAdapter() {
        this.razorpayApi = new RazorpayApi();
    }

    public RazorpayAdapter(RazorpayApi razorpayApi) {
        this.razorpayApi = razorpayApi;
    }

    @Override
    public Payment makePayment(Booking booking) {
        String statusStr = razorpayApi.processPayment(booking.getTotalAmount());

        Payment payment = new Payment();
        payment.setPaymentMode(PaymentMode.UPI);
        payment.setPaymentStatus(PaymentStatus.valueOf(statusStr));

        return payment;
    }
}
