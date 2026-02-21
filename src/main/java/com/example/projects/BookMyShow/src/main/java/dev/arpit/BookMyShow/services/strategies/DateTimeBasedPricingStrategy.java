package dev.arpit.BookMyShow.services.strategies;

import dev.arpit.BookMyShow.models.ShowSeat;

public class DateTimeBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculateSeatPrice(ShowSeat seat) {
        return 0;
    }
}
