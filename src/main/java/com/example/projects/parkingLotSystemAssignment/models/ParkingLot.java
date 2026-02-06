package com.example.projects.parkingLotSystemAssignment.models;

import com.example.projects.parkingLotSystemAssignment.models.constants.ParkingLotStatus;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;

    public ParkingLot() {
    }

    public ParkingLot(String name, List<ParkingFloor> parkingFloors, ParkingLotStatus parkingLotStatus) {
        this.name = name;
        this.parkingFloors = parkingFloors;
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
