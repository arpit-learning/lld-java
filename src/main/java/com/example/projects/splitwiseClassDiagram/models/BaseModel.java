package com.example.projects.splitwiseClassDiagram.models;

import java.time.LocalDateTime;

public abstract class BaseModel {
  private Integer id;
  private LocalDateTime createdOn;
  private LocalDateTime updatedOn;

  public Integer getId () {
    return id;
  }

  public void setId (Integer id) {
    this.id = id;
  }

  public LocalDateTime getCreatedOn () {
    return createdOn;
  }

  public void setCreatedOn (LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public LocalDateTime getUpdatedOn () {
    return updatedOn;
  }

  public void setUpdatedOn (LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }
}