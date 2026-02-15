package dev.arpit.BookMyShow.dtos;

public class CreateSeatResponseDTO {
    private int id;
    private String seatNumber;
    private int seatRow;
    private int seatColumn;
    private String seatType;
    private String seatReservationType;
    private String seatStatus;
    
    public CreateSeatResponseDTO() {
    }

    public CreateSeatResponseDTO(String seatNumber, int seatRow, int seatColumn, String seatType, String seatReservationType) {
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.seatType = seatType;
        this.seatReservationType = seatReservationType;
    }

    public int getId() {
        return id;
    }

    public CreateSeatResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public CreateSeatResponseDTO setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public CreateSeatResponseDTO setSeatRow(int seatRow) {
        this.seatRow = seatRow;
        return this;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public CreateSeatResponseDTO setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
        return this;
    }

    public String getSeatType() {
        return seatType;
    }

    public CreateSeatResponseDTO setSeatType(String seatType) {
        this.seatType = seatType;
        return this;
    }

    public String getSeatReservationType() {
        return seatReservationType;
    }

    public CreateSeatResponseDTO setSeatReservationType(String seatReservationType) {
        this.seatReservationType = seatReservationType;
        return this;
    }
    
    public String getSeatStatus() {
        return seatStatus;
    }
    
    public CreateSeatResponseDTO setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
        return this;
    }
}
