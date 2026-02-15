package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowSeatService {
    ShowSeat save(ShowSeat showSeat);
    List<ShowSeat> getShowSeatsByIds(List<Integer> showSeatIds);
}
