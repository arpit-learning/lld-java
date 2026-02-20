package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidAuditoriumIdException;
import dev.arpit.BookMyShow.exceptions.InvalidMovieIdException;
import dev.arpit.BookMyShow.exceptions.InvalidShowIdException;
import dev.arpit.BookMyShow.models.Auditorium;
import dev.arpit.BookMyShow.models.Movie;
import dev.arpit.BookMyShow.models.Show;
import dev.arpit.BookMyShow.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private AuditoriumService auditoriumService;

    @Override
    public Show findById(int id) throws InvalidShowIdException {
        return showRepository.findById(id).orElseThrow(() -> new InvalidShowIdException("Show with id " + id + " not found.", ResponseCode.ER_400, "Unable to find show. Please try again later."));
    }

    @Override
    public Show createShow(int movieId, int auditoriumId, String showStartTime, String showEndTime, List<String> featuresStr) throws InvalidMovieIdException, InvalidAuditoriumIdException {
        Show show = new Show();
        Movie movie = movieService.findById(movieId);
        Auditorium auditorium = auditoriumService.findById(auditoriumId);
        show.setMovie(movie)
                .setAuditorium(auditorium);

        return showRepository.save(show);
    }
}
