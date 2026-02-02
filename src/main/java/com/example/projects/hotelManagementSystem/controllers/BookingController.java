package com.example.projects.hotelManagementSystem.controllers;

import com.example.projects.hotelManagementSystem.dtos.GenerateInvoiceRequestDto;
import com.example.projects.hotelManagementSystem.dtos.GenerateInvoiceResponseDto;
import com.example.projects.hotelManagementSystem.services.BookingService;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public GenerateInvoiceResponseDto generateInvoice(GenerateInvoiceRequestDto requestDto) {
        return null;
    }
}
