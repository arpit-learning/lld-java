package com.example.projects.bookMyShowClassDiagramAssignment.adapters.pricingadapters;

import com.example.projects.bookMyShowClassDiagramAssignment.models.Booking;
import com.example.projects.bookMyShowClassDiagramAssignment.models.Payment;

public interface PaymentAdapter {
    Payment makePayment(Booking booking);
}
