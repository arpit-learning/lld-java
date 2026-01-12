package com.example.designPatterns.creationalDesignPatterns.decorator;

public class VanillaScoop implements IceCream {
    private IceCream iceCream;

    public VanillaScoop(IceCream iceCream) {
        if (iceCream == null) {
            throw new IllegalArgumentException("Ice Cream cannot be null");
        }
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + ", Vanilla Scoop";
    }
}
