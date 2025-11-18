package com.example.oops.interfacesAndAbstractClasses;

public class Airbus implements Aeroplane {

    @Override
    public void fly() {
        System.out.println("Airbus is flying");
    }

    @Override
    public void land() {
        System.out.println("Airbus is landing");
    }

    @Override
    public void taxi() {
        System.out.println("Airbus is moving on the ground");
    }
}
