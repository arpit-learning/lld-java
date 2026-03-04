package com.example.projects.scalerClassDiagram.models;

import java.util.List;

public class Batch extends BaseModel {
  private String name;
  private List<Learner> learners;
  private BatchTypeIntrinsicData batchTypeIntrinsicData;

  public Batch () {
  }

  public String getName () {
    return name;
  }

  public Batch setName (String name) {
    this.name = name;
    return this;
  }

  public List<Learner> getLearners () {
    return learners;
  }

  public Batch setLearners (List<Learner> learners) {
    this.learners = learners;
    return this;
  }

  public BatchTypeIntrinsicData getBatchTypeIntrinsicData () {
    return batchTypeIntrinsicData;
  }

  public Batch setBatchTypeIntrinsicData (BatchTypeIntrinsicData batchTypeIntrinsicData) {
    this.batchTypeIntrinsicData = batchTypeIntrinsicData;
    return this;
  }
}
