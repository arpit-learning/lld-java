package dev.arpit.BookMyShow.pricingstrategies;

import dev.arpit.BookMyShow.models.ShowSeat;

public class StaticPricingStrategy implements PricingStrategy {
    @Override
    public double calculateSeatPrice(ShowSeat seat) {
        return 0;
    }
}
