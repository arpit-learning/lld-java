package com.example.projects.resturentManagementSystemAssignment.models;

import com.example.projects.resturentManagementSystemAssignment.models.constants.WaiterLevel;

public class Waiter extends BaseModel {
    private WaiterLevel waiterLevel;

    public Waiter() {
    }

    public Waiter(WaiterLevel waiterLevel) {
        this.waiterLevel = waiterLevel;
    }

    public WaiterLevel getWaiterLevel() {
        return waiterLevel;
    }

    public void setWaiterLevel(WaiterLevel waiterLevel) {
        this.waiterLevel = waiterLevel;
    }
}
