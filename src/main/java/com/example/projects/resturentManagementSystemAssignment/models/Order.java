package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.OrderStatus;

import java.util.List;

public class Order extends BaseModel {
    private List<Dish> dishes;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(List<Dish> dishes, OrderStatus orderStatus) {
        this.dishes = dishes;
        this.orderStatus = orderStatus;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
