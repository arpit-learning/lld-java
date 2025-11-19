package com.example.projects.libraryManagementSystem.items;

public abstract class Item {
    private final int itemId;

    public Item(int itemId) {
        this.itemId = itemId;
    }

    public abstract void getDetails();

    public int getItemId() {
        return itemId;
    }
}
