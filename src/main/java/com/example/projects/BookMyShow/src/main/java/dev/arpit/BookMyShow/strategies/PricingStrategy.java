package dev.arpit.BookMyShow.strategies;

import dev.arpit.BookMyShow.models.ShowSeat;

public interface PricingStrategy {
    double calculateSeatPrice(ShowSeat seat);
}
