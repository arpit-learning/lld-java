package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.ShowSeat;
import dev.arpit.BookMyShow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    public ShowSeat save(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    @Override
    public List<ShowSeat> getShowSeatsByIds(List<Integer> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }
}
