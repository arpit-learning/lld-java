package dev.arpit.BookMyShow.adapters;

import dev.arpit.BookMyShow.external.RazorpayApi;
import dev.arpit.BookMyShow.models.*;
import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RazorpayAdapter implements PaymentAdapter {
    private RazorpayApi razorpayApi;

    public RazorpayAdapter() {
        this.razorpayApi = new RazorpayApi();
    }

    public RazorpayAdapter(RazorpayApi razorpayApi) {
        this.razorpayApi = razorpayApi;
    }

    @Override
    public Payment makePayment(double amount) {
        String statusStr = razorpayApi.processPayment(amount);

        Payment payment = new Payment();
        payment.setTransactions(List.of(new Transaction()));
        payment.setPaymentStatus(TransactionPaymentStatus.valueOf(statusStr));

        return payment;
    }
}
