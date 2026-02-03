package com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy;

import com.example.projects.parkingLotSystemDesign.models.constants.VehicleType;

import java.util.HashMap;

public class CostConfiguration {
    public static final double STAGE_1_SURGE_MULTIPLIER = 1.5D;
    public static final double STAGE_2_SURGE_MULTIPLIER = 2.0D;
    public static final double STAGE_3_SURGE_MULTIPLIER = 2.5D;
    public static HashMap<VehicleType, Double> initialHourCostMap;
    public static HashMap<VehicleType, Double> additionalHourCostMap;

    static {
        initialHourCostMap = new HashMap<>();
        initialHourCostMap.put(VehicleType.TWO_WHEELER, 10D);
        initialHourCostMap.put(VehicleType.FOUR_WHEELER, 20D);

        additionalHourCostMap = new HashMap<>();
        additionalHourCostMap.put(VehicleType.TWO_WHEELER, 5D);
        additionalHourCostMap.put(VehicleType.FOUR_WHEELER, 10D);
    }
}
