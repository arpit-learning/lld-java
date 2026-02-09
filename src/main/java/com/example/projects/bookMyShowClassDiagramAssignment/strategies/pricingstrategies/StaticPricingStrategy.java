package com.example.projects.bookMyShowClassDiagramAssignment.strategies.pricingstrategies;

import com.example.projects.bookMyShowClassDiagramAssignment.models.ShowSeat;

public class StaticPricingStrategy implements PricingStrategy {
    @Override
    public double calculateSeatPrice(ShowSeat seat) {
        return 0;
    }
}
