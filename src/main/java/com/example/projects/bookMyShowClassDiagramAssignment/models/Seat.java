package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.SeatReservationType;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.SeatStatus;

public class Seat extends BaseModel {
    private String seatNumber;
    private SeatIntrinsicData seatIntrinsicData;
    private SeatStatus seatStatus;
    private SeatReservationType seatReservationType;

    public Seat() {
        seatStatus = SeatStatus.AVAILABLE;
    }

    public Seat(String seatNumber, SeatIntrinsicData seatIntrinsicData) {
        this.seatNumber = seatNumber;
        this.seatIntrinsicData = seatIntrinsicData;
        seatStatus = SeatStatus.AVAILABLE;
    }

    public Seat(String seatNumber, SeatIntrinsicData seatIntrinsicData, SeatStatus seatStatus, SeatReservationType seatReservationType) {
        this.seatNumber = seatNumber;
        this.seatIntrinsicData = seatIntrinsicData;
        this.seatStatus = seatStatus;
        this.seatReservationType = seatReservationType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatIntrinsicData getSeatIntrinsicData() {
        return seatIntrinsicData;
    }

    public void setSeatIntrinsicData(SeatIntrinsicData seatIntrinsicData) {
        this.seatIntrinsicData = seatIntrinsicData;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatReservationType getSeatReservationType() {
        return seatReservationType;
    }

    public void setSeatReservationType(SeatReservationType seatReservationType) {
        this.seatReservationType = seatReservationType;
    }
}
