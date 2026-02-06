package com.example.projects.parkingLotSystemAssignment.models;

import com.example.projects.parkingLotSystemAssignment.models.constants.ParkingSpotStatus;
import com.example.projects.parkingLotSystemAssignment.models.constants.VehicleType;

public class ParkingSpot extends BaseModel {
    private String parkingSpotNumber;
    private VehicleType vehicleTypeSupported;
    private Vehicle vehicle;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot() {
    }

    public ParkingSpot(String parkingSpotNumber, VehicleType vehicleTypeSupported, Vehicle vehicle, ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.vehicleTypeSupported = vehicleTypeSupported;
        this.vehicle = vehicle;
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public VehicleType getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(VehicleType vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
