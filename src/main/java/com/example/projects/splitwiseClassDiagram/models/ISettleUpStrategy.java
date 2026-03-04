package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public interface ISettleUpStrategy {
  List<Transaction> settleUp (List<Expense> expenses);
}