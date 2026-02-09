package com.example.projects.udemyProjectSystemAssignment.models;

import java.time.LocalDateTime;

public class LectureProgress extends BaseModel {
    private Enrollment enrollment;
    private int lastWatchedSecond;
    private boolean isCompleted;
    private LocalDateTime lastAccessDate;

    public LectureProgress() {
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public int getLastWatchedSecond() {
        return lastWatchedSecond;
    }

    public void setLastWatchedSecond(int lastWatchedSecond) {
        this.lastWatchedSecond = lastWatchedSecond;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }
}
