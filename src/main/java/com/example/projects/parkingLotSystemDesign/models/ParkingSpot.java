package com.example.projects.parkingLotSystemDesign.models;

import com.example.projects.parkingLotSystemDesign.models.constants.ParkingSpotStatus;
import com.example.projects.parkingLotSystemDesign.models.constants.ParkingSpotType;
import com.example.projects.parkingLotSystemDesign.models.constants.VehicleType;

public class ParkingSpot extends BaseModel {
    private String number;
    private VehicleType vehicleType;
    private ParkingSpotStatus status;
    private ParkingSpotType type;
    private Vehicle vehicle;

    public ParkingSpot() {
    }

    public ParkingSpot(String number, VehicleType vehicleType, ParkingSpotStatus status, ParkingSpotType type, Vehicle vehicle) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.status = status;
        this.type = type;
        this.vehicle = vehicle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
