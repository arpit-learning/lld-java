package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public class Expense extends BaseModel {
  private double amount;
  private String description;
  private List<PayoutLedger> payoutLedgers;

  public double getAmount () {
    return amount;
  }

  public void setAmount (double amount) {
    this.amount = amount;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }

  public List<PayoutLedger> getPayoutLedgers () {
    return payoutLedgers;
  }

  public void setPayoutLedgers (List<PayoutLedger> payoutLedgers) {
    this.payoutLedgers = payoutLedgers;
  }
}