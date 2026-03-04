package com.example.projects.splitwiseClassDiagram.models;

public class Transaction extends BaseModel {
  private double amount;
  private User paidBy;
  private User receivedBy;

  public double getAmount () {
    return amount;
  }

  public void setAmount (double amount) {
    this.amount = amount;
  }

  public User getPaidBy () {
    return paidBy;
  }

  public void setPaidBy (User paidBy) {
    this.paidBy = paidBy;
  }

  public User getReceivedBy () {
    return receivedBy;
  }

  public void setReceivedBy (User receivedBy) {
    this.receivedBy = receivedBy;
  }
}
