package com.example.projects.quickCommerceClassDiagramAssignment.models;

import java.util.List;

public class Customer extends User {
    private Cart cart;
    private List<Order> orders;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
