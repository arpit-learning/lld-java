package com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy;

import com.example.projects.parkingLotSystemDesign.exceptions.NotParkingSpotAvailableException;
import com.example.projects.parkingLotSystemDesign.models.ParkingFloor;
import com.example.projects.parkingLotSystemDesign.models.ParkingLot;
import com.example.projects.parkingLotSystemDesign.models.ParkingSpot;
import com.example.projects.parkingLotSystemDesign.models.Vehicle;
import com.example.projects.parkingLotSystemDesign.models.constants.ParkingSpotStatus;

import java.util.List;

public class LinearSpotSearchingStrategy implements SpotSearchingStrategy {
    @Override
    public ParkingSpot findSpot(ParkingLot parkingLot, Vehicle vehicle) {
        List<ParkingFloor> parkingFloorList = parkingLot.getFloors();

        for (ParkingFloor floor : parkingFloorList) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.getVehicleType().equals(vehicle.getVehicleType()) &&
                        spot.getStatus() == ParkingSpotStatus.FREE) {
                    return spot;
                }
            }
        }
        throw new NotParkingSpotAvailableException("No parking spot available for vehicle type: " + vehicle.getVehicleType() + ".");
    }
}
