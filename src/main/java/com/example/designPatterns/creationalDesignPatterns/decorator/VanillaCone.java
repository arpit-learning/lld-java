package com.example.designPatterns.creationalDesignPatterns.decorator;

public class VanillaCone implements IceCream {

    private IceCream iceCream;

    public VanillaCone() {
    }

    public VanillaCone(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if (iceCream != null) {
            return iceCream.getCost() + 20;
        }
        return 20;
    }

    @Override
    public String getDescription() {
        if (iceCream != null) {
            return iceCream.getDescription() + ", Vanilla Cone";
        }
        return "Vanilla Cone";
    }
}
