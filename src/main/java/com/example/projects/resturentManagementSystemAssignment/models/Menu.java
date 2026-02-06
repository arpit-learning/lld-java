package com.example.projects.resturentManagementSystemAssignment.models;

import java.util.List;

public class Menu extends BaseModel {
    private List<Soup> soups;
    private List<Appetizer> appetizers;
    private List<MainCourse> mainCourses;
    private List<Bread> breads;
    private List<Dessert> desserts;

    public Menu() {
    }

    public Menu(List<Soup> soups, List<Appetizer> appetizers, List<MainCourse> mainCourses, List<Bread> breads, List<Dessert> desserts) {
        this.soups = soups;
        this.appetizers = appetizers;
        this.mainCourses = mainCourses;
        this.breads = breads;
        this.desserts = desserts;
    }

    public List<Soup> getSoups() {
        return soups;
    }

    public void setSoups(List<Soup> soups) {
        this.soups = soups;
    }

    public List<Appetizer> getAppetizers() {
        return appetizers;
    }

    public void setAppetizers(List<Appetizer> appetizers) {
        this.appetizers = appetizers;
    }

    public List<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(List<MainCourse> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public List<Bread> getBreads() {
        return breads;
    }

    public void setBreads(List<Bread> breads) {
        this.breads = breads;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }
}
