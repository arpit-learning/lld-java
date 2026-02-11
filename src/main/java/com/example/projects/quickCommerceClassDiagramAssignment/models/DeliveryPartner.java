package com.example.projects.quickCommerceClassDiagramAssignment.models;

import com.example.projects.quickCommerceClassDiagramAssignment.models.constants.DeliveryPartnerStatus;

import java.util.List;

public class DeliveryPartner extends User {
    private DeliveryPartnerStatus deliveryPartnerStatus;
    private PartnerLocation partnerLocation;
    private List<Delivery> deliveries;

    public DeliveryPartnerStatus getDeliveryPartnerStatus() {
        return deliveryPartnerStatus;
    }

    public void setDeliveryPartnerStatus(DeliveryPartnerStatus deliveryPartnerStatus) {
        this.deliveryPartnerStatus = deliveryPartnerStatus;
    }

    public PartnerLocation getPartnerLocation() {
        return partnerLocation;
    }

    public void setPartnerLocation(PartnerLocation partnerLocation) {
        this.partnerLocation = partnerLocation;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
