package com.example.projects.orderProcessingSystem;

import java.util.List;

public class Order {
    private final List<Item> items;
    private double totalAmount;

    public Order(List<Item> items, double totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    // getters
    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
