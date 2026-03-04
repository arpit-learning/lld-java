package com.example.projects.ecomClassDiagram.models;

import java.util.List;

public class Cart extends BaseModel {
  private List<CartInventory> cartInventory;
  private Coupon coupon;
  private double amount;
}
