package com.example.projects.scalerClassDiagram.models;

import java.time.LocalDateTime;

public class BatchWithEntryExitDates extends BaseModel {
  private Batch batch;
  private LocalDateTime entryDate;
  private LocalDateTime exitDate;

  public BatchWithEntryExitDates () {
  }

  public Batch getBatch () {
    return batch;
  }

  public BatchWithEntryExitDates setBatch (Batch batch) {
    this.batch = batch;
    return this;
  }

  public LocalDateTime getEntryDate () {
    return entryDate;
  }

  public BatchWithEntryExitDates setEntryDate (LocalDateTime entryDate) {
    this.entryDate = entryDate;
    return this;
  }

  public LocalDateTime getExitDate () {
    return exitDate;
  }

  public BatchWithEntryExitDates setExitDate (LocalDateTime exitDate) {
    this.exitDate = exitDate;
    return this;
  }
}
