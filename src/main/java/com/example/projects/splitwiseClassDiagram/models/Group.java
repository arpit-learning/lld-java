package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public class Group extends BaseModel {
  private String name;
  private List<User> users;
  private List<Expense> expenses;
  private List<Transaction> transactions;

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public List<User> getUsers () {
    return users;
  }

  public void setUsers (List<User> users) {
    this.users = users;
  }

  public List<Expense> getExpenses () {
    return expenses;
  }

  public void setExpenses (List<Expense> expenses) {
    this.expenses = expenses;
  }

  public List<Transaction> getTransactions () {
    return transactions;
  }

  public void setTransactions (List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
