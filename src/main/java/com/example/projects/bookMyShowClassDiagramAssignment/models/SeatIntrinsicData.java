package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.SeatType;

public class SeatIntrinsicData extends BaseModel {
    private SeatType seatType;
    private double basePrice;

    public SeatIntrinsicData() {
    }

    public SeatIntrinsicData(SeatType seatType, double basePrice) {
        this.seatType = seatType;
        this.basePrice = basePrice;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
