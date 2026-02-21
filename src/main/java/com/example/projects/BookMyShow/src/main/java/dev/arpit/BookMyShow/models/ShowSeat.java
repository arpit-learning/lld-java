package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private double price;
    private String bookedBy;
    @Enumerated
    private ShowSeatStatus showSeatStatus;

    public Seat getSeat() {
        return seat;
    }

    public ShowSeat setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ShowSeat setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public ShowSeat setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
        return this;
    }

    public Show getShow() {
        return show;
    }

    public ShowSeat setShow(Show show) {
        this.show = show;
        return this;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    public ShowSeat setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
        return this;
    }
}