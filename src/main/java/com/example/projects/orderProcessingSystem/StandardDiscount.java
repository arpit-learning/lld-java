package com.example.projects.orderProcessingSystem;

public class StandardDiscount implements DiscountStrategy {
    public double apply(double amount) {
        return amount - amount * 0.2;
    }
}
