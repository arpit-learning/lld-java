package com.example.projects.ecomClassDiagram.models;

public class CartInventory extends BaseModel {
  private Product product;
  private double amount;
  private int quantity;

  public CartInventory () {
  }

  public Product getProduct () {
    return product;
  }

  public CartInventory setProduct (Product product) {
    this.product = product;
    return this;
  }

  public double getAmount () {
    return amount;
  }

  public CartInventory setAmount (double amount) {
    this.amount = amount;
    return this;
  }

  public int getQuantity () {
    return quantity;
  }

  public CartInventory setQuantity (int quantity) {
    this.quantity = quantity;
    return this;
  }
}
