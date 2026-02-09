package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.ScreenStatus;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.ScreenType;

import java.util.ArrayList;
import java.util.List;

public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Show> shows;
    private ScreenStatus screenStatus;
    private ScreenType screenType;

    public Screen() {
        this.seats = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.screenStatus = ScreenStatus.ACTIVE;
        this.screenType = ScreenType.TWO_DIMENSIONAL;
    }

    public Screen(String name) {
        this.name = name;
        this.seats = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.screenStatus = ScreenStatus.ACTIVE;
        this.screenType = ScreenType.TWO_DIMENSIONAL;
    }

    public Screen(String name, List<Seat> seats, List<Show> shows, ScreenStatus screenStatus, ScreenType screenType) {
        this.name = name;
        this.seats = seats;
        this.shows = shows;
        this.screenStatus = screenStatus;
        this.screenType = screenType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public ScreenStatus getScreenStatus() {
        return screenStatus;
    }

    public void setScreenStatus(ScreenStatus screenStatus) {
        this.screenStatus = screenStatus;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }
}
