package com.example.projects.ecomClassDiagram.models;

import java.util.List;

public class Seller extends User {
  private List<Product> products;

  public Seller () {
  }

  public List<Product> getProducts () {
    return products;
  }

  public Seller setProducts (List<Product> products) {
    this.products = products;
    return this;
  }
}
