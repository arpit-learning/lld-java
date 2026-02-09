package com.example.projects.udemyProjectSystemAssignment.models;

import java.time.LocalDateTime;

public class BaseModel {
    private int id;
    private String lastUpdatedBy;
    private String lastCreatedBy;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime lastCreatedDate;

    public BaseModel() {
    }

    public BaseModel(int id, String lastUpdatedBy, String lastCreatedBy, LocalDateTime lastUpdatedDate, LocalDateTime lastCreatedDate) {
        this.id = id;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastCreatedBy = lastCreatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastCreatedDate = lastCreatedDate;
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

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getLastCreatedDate() {
        return lastCreatedDate;
    }

    public void setLastCreatedDate(LocalDateTime lastCreatedDate) {
        this.lastCreatedDate = lastCreatedDate;
    }
}
