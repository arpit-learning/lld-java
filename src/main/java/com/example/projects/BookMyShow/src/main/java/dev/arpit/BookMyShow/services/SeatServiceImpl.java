package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.Seat;
import dev.arpit.BookMyShow.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements  SeatService{
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }
}
