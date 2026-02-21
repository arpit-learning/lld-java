package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidAuditoriumIdException;
import dev.arpit.BookMyShow.exceptions.InvalidMovieIdException;
import dev.arpit.BookMyShow.exceptions.InvalidShowIdException;
import dev.arpit.BookMyShow.models.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {
    Show findById(int id) throws InvalidShowIdException;
    Show createShow(int movieId, int auditoriumId, String showStartTime, String showEndTime, List<String> featuresStr) throws InvalidMovieIdException, InvalidAuditoriumIdException;
    Show save(Show show);
}
