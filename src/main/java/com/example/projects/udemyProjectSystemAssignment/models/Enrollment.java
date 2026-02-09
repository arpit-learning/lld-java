package com.example.projects.udemyProjectSystemAssignment.models;

import java.time.LocalDateTime;

public class Enrollment extends BaseModel {
    boolean isCompleted;
    private User user;
    private Course course;
    private LocalDateTime enrollmentDate;
    private double amountPaid;
    private Review review;

    public Enrollment() {
    }

    public Enrollment(boolean isCompleted, User user, Course course, LocalDateTime enrollmentDate, double amountPaid, Review review) {
        this.isCompleted = isCompleted;
        this.user = user;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.amountPaid = amountPaid;
        this.review = review;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
