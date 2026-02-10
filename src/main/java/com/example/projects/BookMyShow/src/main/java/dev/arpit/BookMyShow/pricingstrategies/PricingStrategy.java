package dev.arpit.BookMyShow.pricingstrategies;

import dev.arpit.BookMyShow.models.ShowSeat;

public interface PricingStrategy {
    double calculateSeatPrice(ShowSeat seat);
}
