package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidSeatIdException;
import dev.arpit.BookMyShow.exceptions.InvalidShowIdException;
import dev.arpit.BookMyShow.models.Seat;
import dev.arpit.BookMyShow.models.Show;
import dev.arpit.BookMyShow.models.ShowSeat;
import dev.arpit.BookMyShow.models.constants.ShowSeatStatus;
import dev.arpit.BookMyShow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowService showService;
    @Autowired
    private SeatService seatService;

    @Override
    public ShowSeat save(ShowSeat showSeat) {
        showSeatRepository.save(showSeat);
        return showSeat;
    }

    @Override
    public ShowSeat createShowSeat(int showId, int seatId, double price) throws InvalidShowIdException, InvalidSeatIdException {
        Show show = showService.findById(showId);
        Seat seat = seatService.findById(seatId);
        ShowSeat showSeat = new ShowSeat();
        showSeat.setShow(show)
                .setSeat(seat)
                .setPrice(price)
                .setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        return showSeatRepository.save(showSeat);
    }

    @Override
    public List<ShowSeat> getShowSeatsByIds(List<Integer> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }

    @Override
    public List<ShowSeat> getAll() {
        return showSeatRepository.findAll();
    }
}
