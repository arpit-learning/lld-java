package com.example.projects.udemyProjectSystemAssignment.models;

public class Video extends BaseModel {
    private String name;
    private String description;
    private String url;
    private int lengthSeconds;
    private String resolution;

    public Video() {
    }

    public Video(String name, String description, String url, int lengthSeconds, String resolution) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.lengthSeconds = lengthSeconds;
        this.resolution = resolution;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLengthSeconds() {
        return lengthSeconds;
    }

    public void setLengthSeconds(int lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
