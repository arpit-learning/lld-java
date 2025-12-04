package com.example.projects.inventoryManagementSystem.items;

public abstract class Item implements Comparable<Item> {
    private final String id;
    private final String name;
    private final double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int compareTo(Item other) {
        return (int) Math.floor(this.price - other.price);
    }
}
