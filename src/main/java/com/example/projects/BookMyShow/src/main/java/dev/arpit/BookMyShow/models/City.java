package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.CityStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City extends BaseModel {
    private String name;
    @OneToMany
    @JoinColumn(name = "city_id")
    private List<Theatre> theatres;
    @Enumerated(EnumType.ORDINAL)
    private CityStatus cityStatus;

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
