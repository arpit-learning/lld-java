package dev.arpit.BookMyShow.services.strategies;

import dev.arpit.BookMyShow.models.ShowSeat;

public interface PricingStrategy {
    double calculateSeatPrice(ShowSeat seat);
}
