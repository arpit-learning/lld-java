package com.example.projects.ecomClassDiagram.models;

public class Advertisement extends BaseModel {
  private Product product;
  private Category category;
  private String content;
  private String link;

  public Advertisement () {
  }

  public Product getProduct () {
    return product;
  }

  public Advertisement setProduct (Product product) {
    this.product = product;
    return this;
  }

  public Category getCategory () {
    return category;
  }

  public Advertisement setCategory (Category category) {
    this.category = category;
    return this;
  }

  public String getContent () {
    return content;
  }

  public Advertisement setContent (String content) {
    this.content = content;
    return this;
  }

  public String getLink () {
    return link;
  }

  public Advertisement setLink (String link) {
    this.link = link;
    return this;
  }
}
