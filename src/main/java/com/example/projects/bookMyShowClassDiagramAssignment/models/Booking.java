package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.BookingStatus;

import java.util.List;

public class Booking extends BaseModel {
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    private double totalAmount;

    public Booking() {
    }

    public Booking(User user, Show show, List<ShowSeat> showSeats, BookingStatus bookingStatus, double totalAmount) {
        this.user = user;
        this.show = show;
        this.showSeats = showSeats;
        this.bookingStatus = bookingStatus;
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
