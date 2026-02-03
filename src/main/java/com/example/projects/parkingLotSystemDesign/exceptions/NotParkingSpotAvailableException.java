package com.example.projects.parkingLotSystemDesign.exceptions;

public class NotParkingSpotAvailableException extends RuntimeException {
    public NotParkingSpotAvailableException(String message) {
        super(message);
    }
}
