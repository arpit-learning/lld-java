package com.example.projects.inventoryManagementSystem.items;

public class Clothing extends Item {
    private final String size;

    public Clothing(String id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }
}
