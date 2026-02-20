package dev.arpit.BookMyShow.dtos;

import java.util.List;

public class CreateMovieRequestDTO {
    private String title;
    private String url;
    private List<String> features;

    public CreateMovieRequestDTO() {
    }

    public CreateMovieRequestDTO(String title, String url, List<String> features) {
        this.title = title;
        this.url = url;
        this.features = features;
    }

    public String getTitle() {
        return title;
    }

    public CreateMovieRequestDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CreateMovieRequestDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public List<String> getFeatures() {
        return features;
    }

    public CreateMovieRequestDTO setFeatures(List<String> features) {
        this.features = features;
        return this;
    }
}
