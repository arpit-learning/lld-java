package com.example.projects.orderProcessingSystem;

public class PremiumDiscount implements DiscountStrategy {
    public double apply(double amount) {
        return amount - amount * 0.5;
    }
}
