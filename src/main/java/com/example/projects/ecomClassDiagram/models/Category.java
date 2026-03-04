package com.example.projects.ecomClassDiagram.models;

import java.util.List;

public class Category extends BaseModel {
  private String name;
  private List<Product> products;

  public Category () {
  }

  public String getName () {
    return name;
  }

  public Category setName (String name) {
    this.name = name;
    return this;
  }

  public List<Product> getProducts () {
    return products;
  }

  public Category setProducts (List<Product> products) {
    this.products = products;
    return this;
  }
}
