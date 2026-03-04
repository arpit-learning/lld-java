package com.example.projects.scalerClassDiagram.models;

import java.time.LocalDateTime;

public class BaseModel {
  private int id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public BaseModel () {
  }

  public int getId () {
    return id;
  }

  public BaseModel setId (int id) {
    this.id = id;
    return this;
  }

  public LocalDateTime getCreatedAt () {
    return createdAt;
  }

  public BaseModel setCreatedAt (LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LocalDateTime getUpdatedAt () {
    return updatedAt;
  }

  public BaseModel setUpdatedAt (LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
