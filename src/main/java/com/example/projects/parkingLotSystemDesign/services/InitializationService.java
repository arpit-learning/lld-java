package com.example.projects.parkingLotSystemDesign.services;

import com.example.projects.parkingLotSystemDesign.models.Gate;
import com.example.projects.parkingLotSystemDesign.models.ParkingFloor;
import com.example.projects.parkingLotSystemDesign.models.ParkingLot;
import com.example.projects.parkingLotSystemDesign.models.ParkingSpot;
import com.example.projects.parkingLotSystemDesign.models.constants.*;
import com.example.projects.parkingLotSystemDesign.repositories.*;

import java.util.ArrayList;
import java.util.List;

public class InitializationService {
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private OperatorRepository operatorRepository;

    public InitializationService() {
        gateRepository = new GateRepository();
        parkingFloorRepository = new ParkingFloorRepository();
        parkingLotRepository = new ParkingLotRepository();
        parkingSpotRepository = new ParkingSpotRepository();
        operatorRepository = new OperatorRepository();
    }

    public void init() {
        System.out.println("************ Starting initialization ***********");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Radhe Parking Lot");
        parkingLot.setAddress("Somewhere inside an expensive mall");
        parkingLot.setStatus(ParkingLotStatus.AVAILABLE);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.TWO_WHEELER, VehicleType.FOUR_WHEELER));
        parkingLotRepository.save(parkingLot);

        for (int i = 1; i <= 10; i++) {
            ParkingFloor floor = new ParkingFloor();
            floor.setFloorNumber(i);
            floor.setStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> spots = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {
                ParkingSpot spot = new ParkingSpot();
                spot.setNumber(i + "0" + j);
                spot.setType(ParkingSpotType.REGULAR);
                spot.setVehicleType(VehicleType.FOUR_WHEELER);
                spot.setStatus(ParkingSpotStatus.FREE);
                parkingSpotRepository.save(spot);
                spots.add(spot);
            }

            Gate entryGate = new Gate();
            entryGate.setType(GateType.ENTRY);
            entryGate.setStatus(GateStatus.OPEN);
            gateRepository.save(entryGate);


            Gate exitGate = new Gate();
            exitGate.setType(GateType.EXIT);
            exitGate.setStatus(GateStatus.OPEN);
            gateRepository.save(exitGate);

            List<Gate> gates = List.of(entryGate, exitGate);

            floor.setParkingSpots(spots);
            floor.setGates(gates);

            parkingFloorRepository.save(floor);
        }
    }
}
