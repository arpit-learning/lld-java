package com.example.oops.inheritance;

public class ICECar extends Car {
    int engineSize;

    public ICECar() {
        System.out.println("Executing the ICECar constructor");
    }

    public void refuelCar() {
        System.out.println("Refueling the ICECar");
    }
}
