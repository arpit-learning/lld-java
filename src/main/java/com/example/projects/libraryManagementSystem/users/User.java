package com.example.projects.libraryManagementSystem.users;

public abstract class User {
    private int userId;
    private String name;
    private String contactInfo;
    private int currentBorrowed = 0;

    // parameterized constructor
    public User(int userId, String name, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public abstract void getDetails();

    public abstract boolean canBorrowBooks();

    // public getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getCurrentBorrowed() {
        return currentBorrowed;
    }

    public void setCurrentBorrowed(int currentBorrowed) {
        this.currentBorrowed = currentBorrowed;
    }
}
