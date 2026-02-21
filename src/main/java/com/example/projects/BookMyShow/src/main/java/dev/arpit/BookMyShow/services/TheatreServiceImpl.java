package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.Theatre;
import dev.arpit.BookMyShow.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre save(Theatre theatre) {
        return theatreRepository.save(theatre);
    }
}
