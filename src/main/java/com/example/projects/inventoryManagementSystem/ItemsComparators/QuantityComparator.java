package com.example.projects.inventoryManagementSystem.ItemsComparators;

import com.example.projects.inventoryManagementSystem.items.Item;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getQuantity() - o2.getQuantity();
    }
}
