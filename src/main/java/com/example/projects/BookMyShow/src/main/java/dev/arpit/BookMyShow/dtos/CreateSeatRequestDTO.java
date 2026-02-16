package dev.arpit.BookMyShow.dtos;

public class CreateSeatRequestDTO {
    private String seatNumber;
    private Integer seatRow;
    private Integer seatColumn;
    private String seatType;
    private String seatReservationType;

    public CreateSeatRequestDTO() {
    }

    public CreateSeatRequestDTO(String seatNumber, Integer seatRow, Integer seatColumn, String seatType, String seatReservationType) {
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.seatType = seatType;
        this.seatReservationType = seatReservationType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public CreateSeatRequestDTO setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public CreateSeatRequestDTO setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
        return this;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public CreateSeatRequestDTO setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
        return this;
    }

    public String getSeatType() {
        return seatType;
    }

    public CreateSeatRequestDTO setSeatType(String seatType) {
        this.seatType = seatType;
        return this;
    }

    public String getSeatReservationType() {
        return seatReservationType;
    }

    public CreateSeatRequestDTO setSeatReservationType(String seatReservationType) {
        this.seatReservationType = seatReservationType;
        return this;
    }
}
