package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidMovieIdException;
import dev.arpit.BookMyShow.models.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    Movie save(Movie movie);
    Movie findById(int id) throws InvalidMovieIdException;
}
