package com.example.projects.inventoryManagementSystem.storage;

import com.example.projects.inventoryManagementSystem.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    private final HashMap<String, T> items;
    private final SearchHistory searchHistory;

    public Inventory(SearchHistory searchHistory) {
        this.items = new HashMap<>();
        this.searchHistory = searchHistory;
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (item.getId() == null) {
            throw new IllegalArgumentException("Item id cannot be null");
        }
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item with id " + item.getId() + " already exists");
        }
        this.items.put(item.getId(), item);
        System.out.println("Item added to inventory : " + item.getName());
    }


    public void remove(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Item id cannot be null");
        }
        searchHistory.remove(id);
        T item = this.items.remove(id);
        if (item == null) {
            throw new IllegalArgumentException("Item with id " + id + " does not exist");
        }
    }

    public T get(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Item id cannot be null");
        }
        T item = this.items.get(id);
        if (item == null) {
            throw new IllegalArgumentException("Item with id " + id + " does not exist");
        }
        searchHistory.add(item);
        System.out.println("Got item : " + item.getName());
        return item;
    }

    public List<T> getAll() {
        return new ArrayList<>(items.values());
    }
}
