package com.example.projects.hotelManagementSystem.repositories;

import com.example.projects.hotelManagementSystem.models.Booking;

import java.util.List;

public interface BookingRepository {
    Booking save(Booking booking);

    List<Booking> findBookingByCustomerSession(long customerSessionId);
}
