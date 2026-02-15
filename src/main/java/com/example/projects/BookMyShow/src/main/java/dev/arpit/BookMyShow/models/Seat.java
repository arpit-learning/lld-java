package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.SeatReservationType;
import dev.arpit.BookMyShow.models.constants.SeatStatus;
import dev.arpit.BookMyShow.models.constants.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    private int seatRow;
    private int seatColumn;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
    @Enumerated(EnumType.ORDINAL)
    private SeatReservationType seatReservationType;

    public String getSeatNumber() {
        return seatNumber;
    }

    public Seat setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public Seat setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
        return this;
    }

    public SeatReservationType getSeatReservationType() {
        return seatReservationType;
    }

    public Seat setSeatReservationType(SeatReservationType seatReservationType) {
        this.seatReservationType = seatReservationType;
        return this;
    }

    public int getRow() {
        return seatRow;
    }

    public Seat setRow(int row) {
        this.seatRow = row;
        return this;
    }

    public int getColumn() {
        return seatColumn;
    }

    public Seat setColumn(int column) {
        this.seatColumn = column;
        return this;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Seat setSeatType(SeatType seatType) {
        this.seatType = seatType;
        return this;
    }
}
