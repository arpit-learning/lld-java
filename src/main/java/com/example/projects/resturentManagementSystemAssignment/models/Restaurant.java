package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.CuisineType;

import java.util.List;

public class Restaurant extends BaseModel {
    private String name;
    private String address;
    private List<CuisineType> cuisineTypes;
    private Menu menu;
    private List<Waiter> waiters;
    private List<Chef> chefs;

    public Restaurant() {
    }

    public Restaurant(String name, String address, List<CuisineType> cuisineTypes, Menu menu, List<Waiter> waiters, List<Chef> chefs) {
        this.name = name;
        this.address = address;
        this.cuisineTypes = cuisineTypes;
        this.menu = menu;
        this.waiters = waiters;
        this.chefs = chefs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Waiter> getWaiters() {
        return waiters;
    }

    public void setWaiters(List<Waiter> waiters) {
        this.waiters = waiters;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }
}
