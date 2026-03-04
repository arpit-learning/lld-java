package com.example.projects.splitwiseClassDiagram.models;

public class SettleUpStrategyFactory {
  public static ISettleUpStrategy getSettleUpStrategy () {
    return new MaxLenderBorrowerMatchSettleUpStrategy();
  }
}