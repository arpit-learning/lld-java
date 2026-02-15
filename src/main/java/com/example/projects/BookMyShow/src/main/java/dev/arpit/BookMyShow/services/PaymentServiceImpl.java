package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.adapters.PaymentAdapter;
import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentAdapter paymentAdapter;

    @Override
    public Payment makePayment(double amount) {
        return paymentAdapter.makePayment(amount);
    }
}
