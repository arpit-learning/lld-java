package com.example.projects.ecomClassDiagram.models;

public class Product extends BaseModel {
  private String name;
  private double price;
  private Category category;

  public Product () {
  }

  public String getName () {
    return name;
  }

  public Product setName (String name) {
    this.name = name;
    return this;
  }

  public double getPrice () {
    return price;
  }

  public Product setPrice (double price) {
    this.price = price;
    return this;
  }

  public Category getCategory () {
    return category;
  }

  public Product setCategory (Category category) {
    this.category = category;
    return this;
  }
}
