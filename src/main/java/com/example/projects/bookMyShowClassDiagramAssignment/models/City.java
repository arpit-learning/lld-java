package com.example.projects.bookMyShowClassDiagramAssignment.models;

import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.CityStatus;

import java.util.ArrayList;
import java.util.List;

public class City extends BaseModel {
    private String name;
    private List<Theatre> theatres;
    private CityStatus cityStatus;

    public City() {
        theatres = new ArrayList<>();
        this.cityStatus = CityStatus.ACTIVE;
    }

    public City(String name) {
        this.name = name;
        theatres = new ArrayList<>();
        this.cityStatus = CityStatus.ACTIVE;
    }

    public City(String name, List<Theatre> theatres, CityStatus cityStatus) {
        this.name = name;
        this.theatres = theatres;
        this.cityStatus = cityStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public CityStatus getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(CityStatus cityStatus) {
        this.cityStatus = cityStatus;
    }
}
