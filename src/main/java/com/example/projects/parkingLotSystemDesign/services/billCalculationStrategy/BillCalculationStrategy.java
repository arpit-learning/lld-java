package com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy;

import com.example.projects.parkingLotSystemDesign.models.Ticket;

public interface BillCalculationStrategy {
    public double calculateBill(Ticket ticket, double occupancyRatio);
}
