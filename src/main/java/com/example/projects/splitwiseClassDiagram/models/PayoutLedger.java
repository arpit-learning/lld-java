package com.example.projects.splitwiseClassDiagram.models;

public class PayoutLedger extends BaseModel {
  private User user;
  private double amount;
  private PayoutType payoutType;

  public User getUser () {
    return user;
  }

  public void setUser (User user) {
    this.user = user;
  }

  public double getAmount () {
    return amount;
  }

  public void setAmount (double amount) {
    this.amount = amount;
  }

  public PayoutType getPayoutType () {
    return payoutType;
  }

  public void setPayoutType (PayoutType payoutType) {
    this.payoutType = payoutType;
  }
}