package com.example.projects.udemyProjectSystemAssignment.models;

public class CourseInstructor extends BaseModel {
    private Course course;
    private Instructor instructor;
    private boolean isPrimaryInstructor;

    public CourseInstructor() {
    }

    public CourseInstructor(Course course, Instructor instructor, boolean isPrimaryInstructor) {
        this.course = course;
        this.instructor = instructor;
        this.isPrimaryInstructor = isPrimaryInstructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public boolean isPrimaryInstructor() {
        return isPrimaryInstructor;
    }

    public void setPrimaryInstructor(boolean primaryInstructor) {
        isPrimaryInstructor = primaryInstructor;
    }
}
