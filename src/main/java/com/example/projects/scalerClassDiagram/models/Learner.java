package com.example.projects.scalerClassDiagram.models;

import java.time.LocalDateTime;
import java.util.List;

public class Learner extends User {
  private List<BatchWithEntryExitDates> batchesEnrolled;
  private Batch currentBatch;
  private LocalDateTime currentBatchEntryDate;

  public Learner () {
  }

  public List<BatchWithEntryExitDates> getBatchesEnrolled () {
    return batchesEnrolled;
  }

  public Learner setBatchesEnrolled (List<BatchWithEntryExitDates> batchesEnrolled) {
    this.batchesEnrolled = batchesEnrolled;
    return this;
  }

  public Batch getCurrentBatch () {
    return currentBatch;
  }

  public Learner setCurrentBatch (Batch currentBatch) {
    this.currentBatch = currentBatch;
    return this;
  }

  public LocalDateTime getCurrentBatchEntryDate () {
    return currentBatchEntryDate;
  }

  public Learner setCurrentBatchEntryDate (LocalDateTime currentBatchEntryDate) {
    this.currentBatchEntryDate = currentBatchEntryDate;
    return this;
  }
}
