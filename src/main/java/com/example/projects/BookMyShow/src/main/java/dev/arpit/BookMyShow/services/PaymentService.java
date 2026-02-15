package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Payment makePayment(double amount);
}
