package com.example.projects.libraryManagementSystem.users;

public class Student extends Member {
    private int studentId;

    public Student(int userId, String name, String contactInfo, int studentId) {
        super(userId, name, contactInfo, 5);
        this.studentId = studentId;
    }

    @Override
    public void getDetails() {
        System.out.println("Student Id: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Current Borrowed: " + getCurrentBorrowed());
    }

    // getter setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
