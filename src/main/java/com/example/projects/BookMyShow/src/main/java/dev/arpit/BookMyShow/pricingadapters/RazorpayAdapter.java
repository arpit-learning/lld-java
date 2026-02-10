package dev.arpit.BookMyShow.pricingadapters;

import dev.arpit.BookMyShow.external.RazorpayApi;
import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.Ticket;
import dev.arpit.BookMyShow.models.Transaction;
import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;

import java.util.List;

public class RazorpayAdapter implements PaymentAdapter {
    private RazorpayApi razorpayApi;

    public RazorpayAdapter() {
        this.razorpayApi = new RazorpayApi();
    }

    public RazorpayAdapter(RazorpayApi razorpayApi) {
        this.razorpayApi = razorpayApi;
    }

    @Override
    public Payment makePayment(Ticket ticket) {
        String statusStr = razorpayApi.processPayment(1234);

        Payment payment = new Payment();
        payment.setTransactions(List.of(new Transaction()));
        payment.setPaymentStatus(TransactionPaymentStatus.valueOf(statusStr));

        return payment;
    }
}
