package com.example.projects.inventoryManagementSystem.items;

public class Electronic extends Item {
    private final int warranty;

    public Electronic(String id, String name, double price, int quantity, int warranty) {
        super(id, name, price, quantity);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }
}
