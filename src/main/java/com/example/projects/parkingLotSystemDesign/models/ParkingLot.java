package com.example.projects.parkingLotSystemDesign.models;

import com.example.projects.parkingLotSystemDesign.models.constants.ParkingLotStatus;
import com.example.projects.parkingLotSystemDesign.models.constants.VehicleType;
import com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy.BillCalculationStrategy;
import com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy.SpotSearchingStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> floors;
    private ParkingLotStatus status;
    private List<VehicleType> vehicleTypesSupported;
    private int capacity;
    private int occupancy;
    private List<Operator> operators;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotSearchingStrategy spotSearchingStrategy;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, List<ParkingFloor> floors, ParkingLotStatus status, List<VehicleType> vehicleTypesSupported, int capacity, List<Operator> operators, BillCalculationStrategy billCalculationStrategy, SpotSearchingStrategy spotSearchingStrategy) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.status = status;
        this.vehicleTypesSupported = vehicleTypesSupported;
        this.capacity = capacity;
        this.occupancy = 0;
        this.operators = operators;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotSearchingStrategy = spotSearchingStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<VehicleType> getVehicleTypesSupported() {
        return vehicleTypesSupported;
    }

    public void setVehicleTypesSupported(List<VehicleType> vehicleTypesSupported) {
        this.vehicleTypesSupported = vehicleTypesSupported;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public SpotSearchingStrategy getSlotSearchingStrategy() {
        return spotSearchingStrategy;
    }

    public void setSlotSearchingStrategy(SpotSearchingStrategy slotSearchingStrategy) {
        this.spotSearchingStrategy = slotSearchingStrategy;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}
