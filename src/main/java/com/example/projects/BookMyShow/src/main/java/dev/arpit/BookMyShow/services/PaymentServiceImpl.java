package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.services.adapters.PaymentAdapter;
import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentAdapter paymentAdapter;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(double amount) {
        Payment payment = paymentAdapter.makePayment(amount);
        payment = paymentRepository.save(payment);
        return payment;
    }
}
