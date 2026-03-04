package com.example.projects.ecomClassDiagram.models;

public class StockInventory extends BaseModel {
  private Product product;
  private int quantity;

  public StockInventory () {
  }

  public Product getProduct () {
    return product;
  }

  public StockInventory setProduct (Product product) {
    this.product = product;
    return this;
  }

  public int getQuantity () {
    return quantity;
  }

  public StockInventory setQuantity (int quantity) {
    this.quantity = quantity;
    return this;
  }
}
