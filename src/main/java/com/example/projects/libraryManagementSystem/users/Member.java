package com.example.projects.libraryManagementSystem.users;

public abstract class Member extends User {
    private int MAX_BORROW_LIMIT;
    private int currentBorrowed = 0;

    public Member(int userId, String name, String contactInfo, int maxBorrowLimit) {
        super(userId, name, contactInfo);
        this.MAX_BORROW_LIMIT = maxBorrowLimit;
    }

    @Override
    public boolean canBorrowBooks() {
        return this.currentBorrowed < this.MAX_BORROW_LIMIT;
    }

    // getter setter

    public int getMaxBorrowLimit() {
        return MAX_BORROW_LIMIT;
    }

    public void setMaxBorrowLimit(int maxBorrowLimit) {
        this.MAX_BORROW_LIMIT = maxBorrowLimit;
    }

    public int getCurrentBorrowed() {
        return currentBorrowed;
    }

    public void setCurrentBorrowed(int currentBorrowed) {
        this.currentBorrowed = currentBorrowed;
    }
}
