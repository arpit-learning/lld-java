package com.example.projects.orderProcessingSystem;

public class OrderProcessor {
    public boolean isOrderValid(Order order) {
        return !order.getItems().isEmpty() && order.getTotalAmount() > 0;
    }

    public void calculateOrderPrice(Order order) {
        double amount = 0;

        for (int i = 0; i < order.getItems().size(); i++) {
            amount += order.getItems().get(i).getPrice();
        }

        amount += 0.18 * amount;
        order.setTotalAmount(amount);
    }

    public void makeDiscount(DiscountStrategy discountStrategy, Order order) {
        order.setTotalAmount(discountStrategy.apply(order.getTotalAmount()));
    }

    public void savesToDB(Order order) {
        // db utilities to save it to DB
    }

    public void sendEmail(Order order) {
        // utility to send email
    }
}
