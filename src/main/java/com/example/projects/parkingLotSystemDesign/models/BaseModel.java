package com.example.projects.parkingLotSystemDesign.models;

import java.time.LocalDateTime;

public abstract class BaseModel {
    private int id;
    private LocalDateTime lastCreatedDate;
    private LocalDateTime lastUpdatedDate;
    private String lastCreatedBy;
    private String lastUpdatedBy;

    public BaseModel() {
    }

    public BaseModel(int id, LocalDateTime lastCreatedDate, LocalDateTime lastUpdatedDate, String lastCreatedBy, String lastUpdatedBy) {
        this.id = id;
        this.lastCreatedDate = lastCreatedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastCreatedBy = lastCreatedBy;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLastCreatedDate() {
        return lastCreatedDate;
    }

    public void setLastCreatedDate(LocalDateTime lastCreatedDate) {
        this.lastCreatedDate = lastCreatedDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastCreatedBy() {
        return lastCreatedBy;
    }

    public void setLastCreatedBy(String lastCreatedBy) {
        this.lastCreatedBy = lastCreatedBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
