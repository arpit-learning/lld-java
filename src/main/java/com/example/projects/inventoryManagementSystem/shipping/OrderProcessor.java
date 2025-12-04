package com.example.projects.inventoryManagementSystem.shipping;

import java.util.PriorityQueue;

public class OrderProcessor {
    PriorityQueue<Order> orders;

    public OrderProcessor() {
        this.orders = new PriorityQueue<>();
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public Order getNextOrder() {
        return this.orders.peek();
    }

}
