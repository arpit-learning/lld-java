package com.example.projects.libraryManagementSystem.items;

public abstract class Item {
    private int itemId;

    public Item(int itemId) {
        this.itemId = itemId;
    }
    
    public abstract void getDetails();
}
