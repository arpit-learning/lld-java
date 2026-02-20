package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidSeatIdException;
import dev.arpit.BookMyShow.models.Seat;
import org.springframework.stereotype.Service;

@Service
public interface SeatService {
    Seat save(Seat seat);
    Seat findById(int id) throws InvalidSeatIdException;
}
