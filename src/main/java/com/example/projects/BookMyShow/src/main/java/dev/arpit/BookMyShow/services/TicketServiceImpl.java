package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.ShowSeatNotAvailableException;
import dev.arpit.BookMyShow.exceptions.ShowSeatsNotFoundException;
import dev.arpit.BookMyShow.exceptions.UserNotFoundException;
import dev.arpit.BookMyShow.models.Payment;
import dev.arpit.BookMyShow.models.ShowSeat;
import dev.arpit.BookMyShow.models.Ticket;
import dev.arpit.BookMyShow.models.User;
import dev.arpit.BookMyShow.models.constants.ShowSeatStatus;
import dev.arpit.BookMyShow.models.constants.TicketStatus;
import dev.arpit.BookMyShow.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private UserService userService;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(List<Integer> showSeatIds, Integer userId) throws UserNotFoundException, ShowSeatsNotFoundException, ShowSeatNotAvailableException {
        User user = userService.getUserById(userId);
        List<ShowSeat> showSeats = showSeatService.getShowSeatsByIds(showSeatIds);

        if(showSeatIds.size() != showSeats.size()) {
            throw new ShowSeatsNotFoundException("Some of the showSeats are not available");
        }

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("ShowSeat " + showSeat.getId() + " is not available");
            }
        }

        for(ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.save(showSeat);
        }

        double amount = showSeats.stream().mapToDouble(ShowSeat::getPrice).sum();
        Payment payment = paymentService.makePayment(amount);

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.BOOKED)
                .setUser(user)
                .setShowSeats(showSeats)
                .setPayment(payment)
                .setShow(showSeats.getFirst().getShow());
        ticketRepository.save(ticket);

        for(ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.save(showSeat);
        }

        return ticket;
    }
}
