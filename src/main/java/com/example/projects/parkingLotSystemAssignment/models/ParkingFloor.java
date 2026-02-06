package com.example.projects.parkingLotSystemAssignment.models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> parkingSpots;
    private String parkingFloorNumber;
    private Gate entryGate, exitGate;

    public ParkingFloor() {
    }

    public ParkingFloor(List<ParkingSpot> parkingSpots, String parkingFloorNumber, Gate entryGate, Gate exitGate) {
        this.parkingSpots = parkingSpots;
        this.parkingFloorNumber = parkingFloorNumber;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public String getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(String parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
