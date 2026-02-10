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

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
