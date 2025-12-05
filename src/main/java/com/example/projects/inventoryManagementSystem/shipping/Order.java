package com.example.projects.inventoryManagementSystem.shipping;

public class Order implements Comparable<Order> {
    private final String orderId;
    private final String itemId;
    private final int quantity;
    private final boolean isExpress;

    public Order(String orderId, String itemId, int quantity, boolean isExpress) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.isExpress = isExpress;
    }

    public int compareTo(Order other) {
        if (this.isExpress == other.isExpress) {
            return this.orderId.compareTo(other.orderId);
        } else if (this.isExpress) {
            return -1;
        } else {
            return 1;
        }

    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpress() {
        return isExpress;
    }
}
