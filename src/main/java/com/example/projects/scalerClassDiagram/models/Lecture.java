package com.example.projects.scalerClassDiagram.models;

public class Lecture extends BaseModel {
  private Batch batch;
  private Instructor instructor;

  public Lecture () {
  }

  public Batch getBatch () {
    return batch;
  }

  public Lecture setBatch (Batch batch) {
    this.batch = batch;
    return this;
  }

  public Instructor getInstructor () {
    return instructor;
  }

  public Lecture setInstructor (Instructor instructor) {
    this.instructor = instructor;
    return this;
  }
}
