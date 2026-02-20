package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidMovieIdException;
import dev.arpit.BookMyShow.models.Movie;
import dev.arpit.BookMyShow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(int id) throws InvalidMovieIdException {
        return movieRepository.findById(id).orElseThrow(() -> new InvalidMovieIdException("Movie with id " + id + " not found.", ResponseCode.ER_400, "Unable to fetch the movie. Please try after some time."));
    }
}
