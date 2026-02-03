package com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillBillCalculationStrategy(BillCalculationStrategies type) {
        return switch (type) {
            case SIMPLE -> new SimpleBillCalculationStrategy();
            case SURGE_BASED -> new SurgeBasedBillCalculationStrategy();
        };
    }
}
