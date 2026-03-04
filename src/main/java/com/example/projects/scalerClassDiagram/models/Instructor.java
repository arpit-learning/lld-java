package com.example.projects.scalerClassDiagram.models;

import java.util.List;

public class Instructor extends User {
  private double averageRating;
  private List<Batch> batches;
  private List<Lecture> lectures;

  public Instructor () {
  }

  public double getAverageRating () {
    return averageRating;
  }

  public Instructor setAverageRating (double averageRating) {
    this.averageRating = averageRating;
    return this;
  }

  public List<Batch> getBatches () {
    return batches;
  }

  public Instructor setBatches (List<Batch> batches) {
    this.batches = batches;
    return this;
  }

  public List<Lecture> getLectures () {
    return lectures;
  }

  public Instructor setLectures (List<Lecture> lectures) {
    this.lectures = lectures;
    return this;
  }
}
