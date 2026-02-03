package com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy;

import com.example.projects.parkingLotSystemDesign.models.Ticket;
import com.example.projects.parkingLotSystemDesign.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBasedBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public double calculateBill(Ticket ticket, double occupancyRatio) {
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();

        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfSeconds = ChronoUnit.SECONDS.between(entryTime, exitTime);
        long hours = (long) Math.ceil((double) numberOfSeconds / 3600);

        double bill = 0;
        bill += CostConfiguration.initialHourCostMap.get(vehicleType);
        bill += CostConfiguration.additionalHourCostMap.get(vehicleType) * (hours - 1);

        if (occupancyRatio > 0.5 && occupancyRatio <= 0.75) {
            bill *= CostConfiguration.STAGE_1_SURGE_MULTIPLIER;
        } else if (occupancyRatio > 0.75 && occupancyRatio <= 0.9) {
            bill *= CostConfiguration.STAGE_2_SURGE_MULTIPLIER;
        } else if (occupancyRatio > 0.9) {
            bill *= CostConfiguration.STAGE_3_SURGE_MULTIPLIER;
        }
        return bill;
    }
}
