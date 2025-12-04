package com.example.projects.inventoryManagementSystem.items;

public class Book extends Item {
    private final String author;

    public Book(String id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }
}
