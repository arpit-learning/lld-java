package com.example.projects.udemyProjectSystemAssignment.models;


import java.util.List;

public class Platform extends BaseModel {
    private List<Instructor> instructors;
    private List<Course> courses;
    private List<User> users;

    public Platform() {
    }

    public Platform(List<Instructor> instructors, List<Course> courses, List<User> users) {
        this.instructors = instructors;
        this.courses = courses;
        this.users = users;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
