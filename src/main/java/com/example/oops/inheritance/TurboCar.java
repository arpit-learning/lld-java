package com.example.oops.inheritance;

public class TurboCar extends Car {
    public TurboCar() {
        System.out.println("Executing the TurboCar constructor");
    }

    @Override // annotation - just for readability / no functional impact
    public void startEngine() {
        System.out.println("Starting engine in the TurboCar");
    }
}
