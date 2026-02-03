package com.example.projects.parkingLotSystemDesign.services;

import com.example.projects.parkingLotSystemDesign.models.*;
import com.example.projects.parkingLotSystemDesign.models.constants.BillStatus;
import com.example.projects.parkingLotSystemDesign.models.constants.ParkingSpotStatus;
import com.example.projects.parkingLotSystemDesign.models.constants.PaymentMode;
import com.example.projects.parkingLotSystemDesign.repositories.*;
import com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy.BillCalculationStrategies;
import com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy.BillCalculationStrategy;
import com.example.projects.parkingLotSystemDesign.services.billCalculationStrategy.BillCalculationStrategyFactory;
import com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy.SpotSearchingStrategies;
import com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy.SpotSearchingStrategy;
import com.example.projects.parkingLotSystemDesign.services.spotAllocationStrategy.SpotSearchingStrategyFactory;

import java.time.LocalDateTime;

public class ParkingLotService {
    private ParkingSpotRepository parkingSpotRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private BillRepository billRepository;

    public ParkingLotService() {
        this.parkingSpotRepository = new ParkingSpotRepository();
        this.ticketRepository = new TicketRepository();
        this.parkingLotRepository = new ParkingLotRepository();
        this.gateRepository = new GateRepository();
        billRepository = new BillRepository();
    }

    public Ticket generateTicket(int parkingLotId, Vehicle vehicle, int gateId) {
        ParkingLot lot = parkingLotRepository.findById(parkingLotId);
        Gate gate = gateRepository.findById(gateId);
        SpotSearchingStrategy strategy = SpotSearchingStrategyFactory.getSpotSearchingStrategy(SpotSearchingStrategies.LINEAR);
        ParkingSpot spot = strategy.findSpot(lot, vehicle);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(spot);
        ticket.setEntryGate(gate);
        ticket.setEntryTime(LocalDateTime.now());

        spot.setStatus(ParkingSpotStatus.OCCUPIED);
        spot.setVehicle(vehicle);

        lot.setOccupancy(lot.getOccupancy() + 1);

        parkingLotRepository.save(lot);
        parkingSpotRepository.save(spot);
        return ticketRepository.save(ticket);
    }

    public Bill generateBill(int parkingLotId, int ticketId, int gateId) {
        ParkingLot lot = parkingLotRepository.findById(parkingLotId);
        Ticket ticket = ticketRepository.findById(ticketId);
        Gate gate = gateRepository.findById(gateId);

        double occupancyRatio = (double) lot.getOccupancy() / lot.getCapacity();
        BillCalculationStrategy strategy = BillCalculationStrategyFactory.getBillBillCalculationStrategy(BillCalculationStrategies.SIMPLE);
        double totalCost = strategy.calculateBill(ticket, occupancyRatio);

        Bill bill = new Bill();
        bill.setExitTime(LocalDateTime.now());
        bill.setAmount(totalCost);
        bill.setTicket(ticket);
        bill.setBillStatus(BillStatus.PAID);
        bill.setPaymentMode(PaymentMode.UPI);
        bill.setPaymentRefNumber("PAY12345");

        ParkingSpot spot = ticket.getParkingSpot();
        spot.setStatus(ParkingSpotStatus.FREE);
        spot.setVehicle(null);

        lot.setOccupancy(lot.getOccupancy() - 1);

        ticketRepository.save(ticket);
        parkingLotRepository.save(lot);

        return billRepository.save(bill);
    }
}
