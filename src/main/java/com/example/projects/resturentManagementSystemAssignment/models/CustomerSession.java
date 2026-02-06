package com.example.projects.resturentManagementSystemAssignment.models;

import java.util.List;

public class CustomerSession extends BaseModel {
    Customer customer;
    Restaurant restaurant;
    List<Order> orders;

    public CustomerSession() {
    }

    public CustomerSession(Customer customer, Restaurant restaurant, List<Order> orders) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
