package com.example.projects.udemyProjectSystemAssignment.models;

import java.util.List;

public class Lecture extends BaseModel {
    private String title;
    private String description;
    private int sequenceOrder;
    private Video video;
    private List<File> referenceMaterials;
    private List<String> readingMaterials;

    public Lecture() {
    }

    public Lecture(String title, String description, int sequenceOrder, Video video, List<File> referenceMaterials, List<String> readingMaterials) {
        this.title = title;
        this.description = description;
        this.sequenceOrder = sequenceOrder;
        this.video = video;
        this.referenceMaterials = referenceMaterials;
        this.readingMaterials = readingMaterials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public List<File> getReferenceMaterials() {
        return referenceMaterials;
    }

    public void setReferenceMaterials(List<File> referenceMaterials) {
        this.referenceMaterials = referenceMaterials;
    }

    public List<String> getReadingMaterials() {
        return readingMaterials;
    }

    public void setReadingMaterials(List<String> readingMaterials) {
        this.readingMaterials = readingMaterials;
    }
}
