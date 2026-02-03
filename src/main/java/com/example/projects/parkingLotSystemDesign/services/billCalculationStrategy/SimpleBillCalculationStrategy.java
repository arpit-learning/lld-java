package com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy;

import com.example.projects.parkingLotSystemDesign.models.Ticket;
import com.example.projects.parkingLotSystemDesign.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleBillCalculationStrategy implements BillCalculationStrategy {
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
        return bill;
    }
}
