package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.TheatreStatus;

import java.util.ArrayList;
import java.util.List;

public class Theatre extends BaseModel {
    private String name;
    private List<Screen> screens;
    private TheatreStatus theatreStatus;

    public Theatre() {
        screens = new ArrayList<>();
        theatreStatus = TheatreStatus.ACTIVE;
    }

    public Theatre(String name) {
        this.name = name;
        screens = new ArrayList<>();
        theatreStatus = TheatreStatus.ACTIVE;
    }

    public Theatre(String name, List<Screen> screens, TheatreStatus theatreStatus) {
        this.name = name;
        this.screens = screens;
        this.theatreStatus = theatreStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public TheatreStatus getTheatreStatus() {
        return theatreStatus;
    }

    public void setTheatreStatus(TheatreStatus theatreStatus) {
        this.theatreStatus = theatreStatus;
    }
}
