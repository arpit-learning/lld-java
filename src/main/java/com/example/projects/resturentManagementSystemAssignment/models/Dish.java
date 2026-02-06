package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.DishStatus;
import com.example.projects.resturentManagementSystemAssignment.models.constants.DishType;

import java.util.List;
import java.util.Map;

public abstract class Dish extends BaseModel {
    private String name;
    private String description;
    private DishType dishType;
    private double price;
    private List<String> recipe;
    private DishStatus dishStatus;
    private List<Map<Ingredient, Double>> ingredients;

    public Dish() {
    }

    public Dish(String name, String description, DishType dishType, double price, List<String> recipe, DishStatus dishStatus, List<Map<Ingredient, Double>> ingredients) {
        this.name = name;
        this.description = description;
        this.dishType = dishType;
        this.price = price;
        this.recipe = recipe;
        this.dishStatus = dishStatus;
        this.ingredients = ingredients;
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

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }

    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(DishStatus dishStatus) {
        this.dishStatus = dishStatus;
    }


    public List<Map<Ingredient, Double>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Map<Ingredient, Double>> ingredients) {
        this.ingredients = ingredients;
    }
}
