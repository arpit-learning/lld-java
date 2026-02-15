package dev.arpit.BookMyShow.mappers;


import dev.arpit.BookMyShow.dtos.CreateTicketResponseDTO;
import dev.arpit.BookMyShow.models.ShowSeat;
import dev.arpit.BookMyShow.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDTOMapper {

    public static CreateTicketResponseDTO getTicketResponseDTO(Ticket ticket) {
        CreateTicketResponseDTO responseDTO = new CreateTicketResponseDTO();
        responseDTO
                .setId(ticket.getId())
                .setMovieTitle(ticket.getShow().getMovie().getTitle())
                .setAuditoriumName(ticket.getShow().getAuditorium().getName())
                .setShowStartTime(ticket.getShow().getShowStartTime());
        List<String> seats = new ArrayList<>();
        for(ShowSeat showSeat : ticket.getShowSeats()){
            seats.add(showSeat.getSeat().getSeatNumber());
        }
        responseDTO.setSeatNumbers(seats);
        return responseDTO;
    }
}
