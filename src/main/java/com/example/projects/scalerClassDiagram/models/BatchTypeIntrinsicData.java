package com.example.projects.scalerClassDiagram.models;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class BatchTypeIntrinsicData extends BaseModel {
  private BatchType batchType;
  private LocalDateTime lectureStartTime;
  private LocalDateTime lectureEndTime;
  private List<DayOfWeek> lectureDays;

  public BatchTypeIntrinsicData () {
  }

  public BatchType getBatchType () {
    return batchType;
  }

  public BatchTypeIntrinsicData setBatchType (BatchType batchType) {
    this.batchType = batchType;
    return this;
  }

  public LocalDateTime getLectureStartTime () {
    return lectureStartTime;
  }

  public BatchTypeIntrinsicData setLectureStartTime (LocalDateTime lectureStartTime) {
    this.lectureStartTime = lectureStartTime;
    return this;
  }

  public LocalDateTime getLectureEndTime () {
    return lectureEndTime;
  }

  public BatchTypeIntrinsicData setLectureEndTime (LocalDateTime lectureEndTime) {
    this.lectureEndTime = lectureEndTime;
    return this;
  }

  public List<DayOfWeek> getLectureDays () {
    return lectureDays;
  }

  public BatchTypeIntrinsicData setLectureDays (List<DayOfWeek> lectureDays) {
    this.lectureDays = lectureDays;
    return this;
  }
}
