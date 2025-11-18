package com.example.projects.libraryManagementSystem.users;

public class Professor extends Member {
    private int professorId;

    public Professor(int userId, String name, String contactInfo, int professorId) {
        super(userId, name, contactInfo, 15);
        this.professorId = professorId;
    }

    @Override
    public void getDetails() {
        System.out.println("Professor Id: " + professorId);
        System.out.println("Name: " + getName());
        System.out.println("Current Borrowed: " + getCurrentBorrowed());
    }

    // getter setters
    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
