package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.Theatre;
import org.springframework.stereotype.Service;

@Service
public interface TheatreService {
    Theatre save(Theatre theatre);
}
