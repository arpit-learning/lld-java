package com.example.projects.scalerClassDiagram.models;

public class Rating extends BaseModel {
  private Lecture lecture;
  private Learner learner;
  private double value;

  public Rating () {
  }

  public Lecture getLecture () {
    return lecture;
  }

  public Rating setLecture (Lecture lecture) {
    this.lecture = lecture;
    return this;
  }

  public Learner getLearner () {
    return learner;
  }

  public Rating setLearner (Learner learner) {
    this.learner = learner;
    return this;
  }

  public double getValue () {
    return value;
  }

  public Rating setValue (double value) {
    this.value = value;
    return this;
  }
}
