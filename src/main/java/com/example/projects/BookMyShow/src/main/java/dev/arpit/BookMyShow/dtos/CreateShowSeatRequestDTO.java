package dev.arpit.BookMyShow.dtos;

public class CreateShowSeatRequestDTO {
    private Integer showId;
    private Integer seatId;
    private Double price;

    public CreateShowSeatRequestDTO() {
    }

    public CreateShowSeatRequestDTO(Integer showId, Integer seatId, Double price) {
        this.showId = showId;
        this.seatId = seatId;
        this.price = price;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
