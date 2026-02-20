package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.Feature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Movie extends BaseModel {
    private String title;
    @OneToOne
    private Rating rating;
    private String url;
    @Enumerated
    @ElementCollection
    private List<Feature> features;

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Movie setFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public Movie setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Movie setUrl(String url) {
        this.url = url;
        return this;
    }
}
