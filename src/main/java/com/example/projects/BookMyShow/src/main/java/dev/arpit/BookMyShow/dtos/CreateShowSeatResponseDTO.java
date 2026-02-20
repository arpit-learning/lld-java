package dev.arpit.BookMyShow.dtos;

public class CreateShowSeatResponseDTO {
    private int showSeatId;
    private int seatId;
    private int showId;
    private double price;
    private String showSeatStatus;

    public CreateShowSeatResponseDTO() {
    }

    public CreateShowSeatResponseDTO(int showSeatId, int seatId, int showId, double price, String showSeatStatus) {
        this.showSeatId = showSeatId;
        this.seatId = seatId;
        this.showId = showId;
        this.price = price;
        this.showSeatStatus = showSeatStatus;
    }

    public int getShowSeatId() {
        return showSeatId;
    }

    public CreateShowSeatResponseDTO setShowSeatId(int showSeatId) {
        this.showSeatId = showSeatId;
        return this;
    }

    public int getSeatId() {
        return seatId;
    }

    public CreateShowSeatResponseDTO setSeatId(int seatId) {
        this.seatId = seatId;
        return this;
    }

    public int getShowId() {
        return showId;
    }

    public CreateShowSeatResponseDTO setShowId(int showId) {
        this.showId = showId;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CreateShowSeatResponseDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getShowSeatStatus() {
        return showSeatStatus;
    }

    public CreateShowSeatResponseDTO setShowSeatStatus(String showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
        return this;
    }
}
