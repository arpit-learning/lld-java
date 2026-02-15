package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateUserRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateUserResponseDTO;
import dev.arpit.BookMyShow.dtos.CreateTicketResponseDTO;
import dev.arpit.BookMyShow.models.Ticket;
import dev.arpit.BookMyShow.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMapper {

    public static User getUser(CreateUserRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.getName())
            .setEmail(requestDTO.getEmail())
            .setPassword(requestDTO.getPassword());
        return user;
    }

    public static CreateUserResponseDTO getCreateUserResponseDTO(User user) {
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail());
        if(user.getTickets() != null) {
            List<CreateTicketResponseDTO> tickets = new ArrayList<>();
                for (Ticket ticket : user.getTickets()) {
                    tickets.add(TicketDTOMapper.getTicketResponseDTO(ticket));
                }
            responseDTO.setTickets(tickets);
        }
        return responseDTO;
    }
}
