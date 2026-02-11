package com.example.projects.quickCommerceClassDiagramAssignment.models;

import com.example.projects.quickCommerceClassDiagramAssignment.models.constants.DeliveryStatus;

import java.time.LocalDateTime;

public class Delivery extends BaseModel {
    private Order order;
    private DeliveryPartner deliveryPartner;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime pickupTime;
    private LocalDateTime deliveryTime;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
