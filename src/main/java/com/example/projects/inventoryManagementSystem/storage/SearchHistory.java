package com.example.projects.inventoryManagementSystem.storage;

import com.example.projects.inventoryManagementSystem.items.Item;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SearchHistory {
    private final int MAX_ALLOWED = 3;
    private final Deque<Item> deque;

    public SearchHistory() {
        this.deque = new LinkedList<>();
    }

    public void add(Item item) {
        deque.remove(item);
        deque.addFirst(item);
        if (deque.size() > MAX_ALLOWED) {
            deque.removeLast();
        }
    }

    public void remove(String id) {
        deque.removeIf(item -> item.getId().equals(id));
    }

    public List<Item> getHistory() {
        return new ArrayList<>(deque);
    }
}
