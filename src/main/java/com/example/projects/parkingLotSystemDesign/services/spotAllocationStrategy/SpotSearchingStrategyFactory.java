package com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy;

public class SpotSearchingStrategyFactory {
    public static SpotSearchingStrategy getSpotSearchingStrategy(SpotSearchingStrategies type) {
        return switch (type) {
            case LINEAR -> new LinearSpotSearchingStrategy();
            case NEAR_ENTRY_EXIT -> new NearEntryExitSpotSearchingStrategy();
        };
    }
}
