package com.example.projects.udemyProjectSystemAssignment.models;

import java.util.List;

public class Module extends BaseModel {
    private String name;
    private int sequenceOrder;
    private List<Lecture> lectures;

    public Module() {
    }

    public Module(String name, int sequenceOrder, List<Lecture> lectures) {
        this.name = name;
        this.sequenceOrder = sequenceOrder;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
