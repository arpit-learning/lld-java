package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.AuditoriumStatus;
import dev.arpit.BookMyShow.models.constants.Feature;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Auditorium extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    @Enumerated(EnumType.ORDINAL)
    private AuditoriumStatus auditoriumStatus;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public AuditoriumStatus getAuditoriumStatus() {
        return auditoriumStatus;
    }

    public void setAuditoriumStatus(AuditoriumStatus auditoriumStatus) {
        this.auditoriumStatus = auditoriumStatus;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
