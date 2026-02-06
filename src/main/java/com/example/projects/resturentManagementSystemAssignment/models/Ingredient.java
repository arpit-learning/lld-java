package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.IngredientType;

public class Ingredient extends BaseModel {
    private String name;
    private IngredientType ingredientType;
    private double price;

    public Ingredient() {
    }

    public Ingredient(String name, IngredientType ingredientType, double price) {
        this.name = name;
        this.ingredientType = ingredientType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
