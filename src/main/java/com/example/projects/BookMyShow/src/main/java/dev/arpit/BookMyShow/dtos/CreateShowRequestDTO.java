package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateShowRequestDTO {
    private Integer movieId;
    private String showStartTime;
    private String showEndTime;
    private Integer auditoriumId;
    private List<String> features;

    public CreateShowRequestDTO() {
    }

    public CreateShowRequestDTO(Integer movieId, String showStartTime, String showEndTime, Integer auditoriumId, List<String> features) {
        this.movieId = movieId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.auditoriumId = auditoriumId;
        this.features = features;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public CreateShowRequestDTO setMovieId(Integer movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public CreateShowRequestDTO setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
        return this;
    }

    public String getShowEndTime() {
        return showEndTime;
    }

    public CreateShowRequestDTO setShowEndTime(String showEndTime) {
        this.showEndTime = showEndTime;
        return this;
    }

    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    public CreateShowRequestDTO setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
        return this;
    }

    public List<String> getFeatures() {
        return features;
    }

    public CreateShowRequestDTO setFeatures(List<String> features) {
        this.features = features;
        return this;
    }
}
