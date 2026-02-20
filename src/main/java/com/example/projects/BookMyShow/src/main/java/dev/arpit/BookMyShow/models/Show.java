package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.Feature;
import dev.arpit.BookMyShow.models.constants.ShowStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private LocalDateTime showStartTime, showEndTime;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    @JoinColumn(name = "show_id")
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private ShowStatus showStatus;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public Movie getMovie() {
        return movie;
    }

    public Show setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public Show setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
        return this;
    }

    public LocalDateTime getShowEndTime() {
        return showEndTime;
    }

    public Show setShowEndTime(LocalDateTime showEndTime) {
        this.showEndTime = showEndTime;
        return this;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public Show setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
        return this;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public Show setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
        return this;
    }

    public ShowStatus getShowStatus() {
        return showStatus;
    }

    public Show setShowStatus(ShowStatus showStatus) {
        this.showStatus = showStatus;
        return this;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Show setFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }
}
