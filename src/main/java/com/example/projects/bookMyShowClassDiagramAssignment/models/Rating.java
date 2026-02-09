package com.example.projects.bookMyShowClassDiagramAssignment.models;

import java.util.ArrayList;
import java.util.List;

public class Rating extends BaseModel {
    private double stars;
    private List<Comment> comments;

    public Rating() {
        this.comments = new ArrayList<>();
    }

    public Rating(double stars, List<Comment> comments) {
        this.stars = stars;
        this.comments = comments;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
