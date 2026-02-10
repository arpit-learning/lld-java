package dev.arpit.BookMyShow.pricingadapters;

import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.Ticket;

public interface PaymentAdapter {
    Payment makePayment(Ticket ticket);
}
