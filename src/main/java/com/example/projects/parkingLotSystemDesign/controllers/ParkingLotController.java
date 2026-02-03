package com.example.projects.parkingLotSystemDesign.controllers;

import com.example.projects.parkingLotSystemDesign.services.ParkingLotService;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController() {
        this.parkingLotService = new ParkingLotService();
    }
}
