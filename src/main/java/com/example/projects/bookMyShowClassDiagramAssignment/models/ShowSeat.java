package com.example.projects.bookMyShowClassDiagramAssignment.models;

public class ShowSeat extends BaseModel {
    private Seat seat;
    private double price;
    private String bookedBy;
    private String bookingTime;

    public ShowSeat() {
    }

    public ShowSeat(Seat seat, double price, String bookedBy, String bookingTime) {
        this.seat = seat;
        this.price = price;
        this.bookedBy = bookedBy;
        this.bookingTime = bookingTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
