package dev.arpit.BookMyShow.services.adapters;

import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.Ticket;
import org.springframework.stereotype.Component;

@Component
public interface PaymentAdapter {
    Payment makePayment(double amount);
}
