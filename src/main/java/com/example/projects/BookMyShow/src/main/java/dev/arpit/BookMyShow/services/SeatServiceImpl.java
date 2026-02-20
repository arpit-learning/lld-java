package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidSeatIdException;
import dev.arpit.BookMyShow.models.Seat;
import dev.arpit.BookMyShow.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat findById(int id) throws InvalidSeatIdException {
        return seatRepository.findById(id).orElseThrow(() -> new InvalidSeatIdException("Seat with id " + id + " not found.", ResponseCode.ER_400, "Unable to find seat. Please try again later."));
    }
}
