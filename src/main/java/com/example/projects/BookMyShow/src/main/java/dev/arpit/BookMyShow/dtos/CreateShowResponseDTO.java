package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateShowResponseDTO {
    private int id;
    private int movieId;
    private String showStartTime;
    private String showEndTime;
    private int auditoriumId;
    private List<String> features;

    public CreateShowResponseDTO() {
    }

    public CreateShowResponseDTO(int id, int movieId, String showStartTime, String showEndTime, int auditoriumId, List<String> features) {
        this.id = id;
        this.movieId = movieId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.auditoriumId = auditoriumId;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public CreateShowResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getMovieId() {
        return movieId;
    }

    public CreateShowResponseDTO setMovieId(int movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public CreateShowResponseDTO setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
        return this;
    }

    public String getShowEndTime() {
        return showEndTime;
    }

    public CreateShowResponseDTO setShowEndTime(String showEndTime) {
        this.showEndTime = showEndTime;
        return this;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public CreateShowResponseDTO setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
        return this;
    }

    public List<String> getFeatures() {
        return features;
    }

    public CreateShowResponseDTO setFeatures(List<String> features) {
        this.features = features;
        return this;
    }
}
