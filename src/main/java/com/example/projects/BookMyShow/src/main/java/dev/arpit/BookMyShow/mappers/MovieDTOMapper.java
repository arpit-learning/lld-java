package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateMovieRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateMovieResponseDTO;
import dev.arpit.BookMyShow.models.Movie;
import dev.arpit.BookMyShow.models.constants.Feature;

import java.util.ArrayList;
import java.util.List;

public class MovieDTOMapper {
    public static Movie getMovie(CreateMovieRequestDTO requestDTO) {
        Movie movie = new Movie();
        movie.setTitle(requestDTO.getTitle())
                .setUrl(requestDTO.getUrl());

        List<Feature> features = new ArrayList<>();
        for(String featureStr: requestDTO.getFeatures()) {
            features.add(Feature.valueOf(featureStr));
        }
        movie.setFeatures(features);

        return movie;
    }

    public static CreateMovieResponseDTO getCreateMovieResponseDTO(Movie movie) {
        CreateMovieResponseDTO createMovieResponseDTO = new CreateMovieResponseDTO();
        createMovieResponseDTO.setTitle(movie.getTitle())
                .setUrl(movie.getUrl())
                .setId(movie.getId());
        List<String> featuresStr = new ArrayList<>();
        for(Feature feature: movie.getFeatures()) {
            featuresStr.add(feature.toString());
        }
        createMovieResponseDTO.setFeatures(featuresStr);
        return createMovieResponseDTO;
    }
}
