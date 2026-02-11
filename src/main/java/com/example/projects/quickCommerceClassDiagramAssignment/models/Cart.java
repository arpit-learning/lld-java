package com.example.projects.quickCommerceClassDiagramAssignment.models;

import java.util.List;

public class Cart extends BaseModel {
    List<CartItem> items;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
