package com.example.projects.bookMyShowClassDiagramAssignment.models;

public class Movie extends BaseModel {
    private String name;
    private Rating rating;
    private String url;

    public Movie() {
    }

    public Movie(String name, Rating rating, String url) {
        this.name = name;
        this.rating = rating;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
