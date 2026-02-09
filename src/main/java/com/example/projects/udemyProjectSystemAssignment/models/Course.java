package com.example.projects.udemyProjectSystemAssignment.models;

import java.util.List;

public class Course extends BaseModel {
    private String name;
    private String description;
    private double price;
    private List<Module> modules;

    public Course() {
    }

    public Course(String name, String description, double price, List<Module> modules) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.modules = modules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
