package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidAuditoriumIdException;
import dev.arpit.BookMyShow.models.Auditorium;
import dev.arpit.BookMyShow.repositories.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public Auditorium findById(int id) throws InvalidAuditoriumIdException {
        return auditoriumRepository.findById(id).orElseThrow(() -> new InvalidAuditoriumIdException("Auditorium with id " + id + " not found.", ResponseCode.ER_400, "Unable to find auditorium. Please try again later."));
    }
}
