package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidSeatIdException;
import dev.arpit.BookMyShow.exceptions.InvalidShowIdException;
import dev.arpit.BookMyShow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowSeatService {
    ShowSeat createShowSeat(int showId, int seatId, double price) throws InvalidShowIdException, InvalidSeatIdException;
    ShowSeat save(ShowSeat showSeat);
    List<ShowSeat> getShowSeatsByIds(List<Integer> showSeatIds);
}
