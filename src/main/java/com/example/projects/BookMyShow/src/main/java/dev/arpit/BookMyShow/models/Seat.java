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

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
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

    public int getRow() {
        return seatRow;
    }

    public void setRow(int row) {
        this.seatRow = row;
    }

    public int getColumn() {
        return seatColumn;
    }

    public void setColumn(int column) {
        this.seatColumn = column;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
