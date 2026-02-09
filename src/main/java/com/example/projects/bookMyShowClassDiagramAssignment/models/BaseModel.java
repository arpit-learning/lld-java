package com.example.projects.bookMyShowClassDiagramAssignment.models;

import java.time.LocalDateTime;

public class BaseModel {
    private int id;
    private String lastUpdatedBy;
    private String lastCreatedBy;
    private LocalDateTime lastUpdatedOn;
    private LocalDateTime lastCreatedOn;

    public BaseModel() {
    }

    public BaseModel(int id, String lastUpdatedBy, String lastCreatedBy, LocalDateTime lastUpdatedOn, LocalDateTime lastCreatedOn) {
        this.id = id;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastCreatedBy = lastCreatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastCreatedOn = lastCreatedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastCreatedBy() {
        return lastCreatedBy;
    }

    public void setLastCreatedBy(String lastCreatedBy) {
        this.lastCreatedBy = lastCreatedBy;
    }

    public LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public LocalDateTime getLastCreatedOn() {
        return lastCreatedOn;
    }

    public void setLastCreatedOn(LocalDateTime lastCreatedOn) {
        this.lastCreatedOn = lastCreatedOn;
    }
}
