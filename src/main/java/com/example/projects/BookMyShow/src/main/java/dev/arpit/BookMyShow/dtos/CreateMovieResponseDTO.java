package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateMovieResponseDTO {
    private int id;
    private String title;
    private String url;
    private List<String> features;

    public CreateMovieResponseDTO() {
    }

    public CreateMovieResponseDTO(int id, String title, String url, List<String> features) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public CreateMovieResponseDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateMovieResponseDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CreateMovieResponseDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public List<String> getFeatures() {
        return features;
    }

    public CreateMovieResponseDTO setFeatures(List<String> features) {
        this.features = features;
        return this;
    }
}
