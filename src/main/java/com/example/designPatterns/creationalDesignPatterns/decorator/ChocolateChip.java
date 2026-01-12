package com.example.designPatterns.creationalDesignPatterns.decorator;

public class ChocolateChip implements IceCream {
    private IceCream iceCream;

    public ChocolateChip(IceCream iceCream) {
        if (iceCream == null) {
            throw new IllegalArgumentException("Ice Cream cannot be null");
        }
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + ", Chocolate Chip";
    }
}
