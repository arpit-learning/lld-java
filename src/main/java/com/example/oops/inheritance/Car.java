package com.example.oops.inheritance;

public class Car {
    int id;
    String model;
    String color;

    public Car() {
        System.out.println("Executing the Car constructor");
    }

    public void unlockCar() {
        System.out.println("Unlocking the Car");
    }

    public void changeEngineOil() {
        System.out.println("Changing engine oil in the Car");
    }

    public void startEngine() {
        System.out.println("Starting engine in the Car");
    }
}
