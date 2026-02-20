package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidAuditoriumIdException;
import dev.arpit.BookMyShow.models.Auditorium;
import org.springframework.stereotype.Service;

@Service
public interface AuditoriumService {
   Auditorium findById(int id) throws InvalidAuditoriumIdException;
}
