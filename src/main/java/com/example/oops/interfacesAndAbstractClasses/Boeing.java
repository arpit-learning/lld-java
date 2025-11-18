package com.example.oops.interfacesAndAbstractClasses;

public class Boeing implements Aeroplane, LuggageCarrier {

    @Override
    public void fly() {
        System.out.println("Boeing plane is flying");
    }

    @Override
    public void land() {
        System.out.println("Boeing plane is landing");
    }

    @Override
    public void taxi() {
        System.out.println("Boeing plane is moving on ground");
    }

    @Override
    public void carryLuggage() {
        System.out.println("Boeing plane is carrying luggage");
    }
}
