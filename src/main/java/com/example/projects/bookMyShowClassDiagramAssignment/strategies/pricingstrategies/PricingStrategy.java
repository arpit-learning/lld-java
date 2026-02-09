package com.example.projects.bookMyShowClassDiagramAssignment.strategies.pricingstrategies;

import com.example.projects.bookMyShowClassDiagramAssignment.models.ShowSeat;

public interface PricingStrategy {
    double calculateSeatPrice(ShowSeat seat);
}
