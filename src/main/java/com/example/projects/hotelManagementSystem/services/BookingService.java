package com.example.projects.hotelManagementSystem.services;

import com.example.projects.hotelManagementSystem.exceptions.CustomerSessionNotFoundException;
import com.example.projects.hotelManagementSystem.models.Invoice;

public interface BookingService {
    Invoice generateInvoice(long userId) throws CustomerSessionNotFoundException;
}
