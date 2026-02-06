package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.ChefLevel;

public class Chef extends User {
    private ChefLevel chefLevel;

    public Chef() {
    }

    public Chef(ChefLevel chefLevel) {
        this.chefLevel = chefLevel;
    }

    public ChefLevel getChefLevel() {
        return chefLevel;
    }

    public void setChefLevel(ChefLevel chefLevel) {
        this.chefLevel = chefLevel;
    }
}
