package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.ShowStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Show extends BaseModel {
    private String name;
    private Movie movie;
    private ShowStatus showStatus;
    private List<ShowSeat> showSeats;
    private LocalDateTime showStartTime, showEndTime;

    public Show() {
    }

    public Show(String name, Movie movie, ShowStatus showStatus, List<ShowSeat> showSeats, LocalDateTime showStartTime, LocalDateTime showEndTime) {
        this.name = name;
        this.movie = movie;
        this.showStatus = showStatus;
        this.showSeats = showSeats;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ShowStatus getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(ShowStatus showStatus) {
        this.showStatus = showStatus;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public LocalDateTime getShowEndTime() {
        return showEndTime;
    }

    public void setShowEndTime(LocalDateTime showEndTime) {
        this.showEndTime = showEndTime;
    }
}
