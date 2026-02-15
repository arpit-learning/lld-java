package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.ShowSeatNotAvailableException;
import dev.arpit.BookMyShow.exceptions.ShowSeatsNotFoundException;
import dev.arpit.BookMyShow.exceptions.UserNotFoundException;
import dev.arpit.BookMyShow.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    Ticket createTicket(List<Integer> showSeatIds, Integer userId) throws UserNotFoundException, ShowSeatsNotFoundException, ShowSeatNotAvailableException;
}
