package com.example.projects.libraryManagementSystem.users;

public class Employee extends User {
    private int employeeId;

    public Employee(int userId, String name, String contactInfo, int employeeId) {
        super(userId, name, contactInfo);
        this.employeeId = employeeId;
    }

    @Override
    public void getDetails() {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    // getter setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
