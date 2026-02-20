package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateShowSeatRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateShowSeatResponseDTO;
import dev.arpit.BookMyShow.models.ShowSeat;

public class ShowSeatDTOMapper {
    public static CreateShowSeatResponseDTO getCreateShowSeatResponseDTO(ShowSeat showSeat) {
         CreateShowSeatResponseDTO responseDTO = new CreateShowSeatResponseDTO();
         responseDTO.setShowSeatId(showSeat.getId())
                 .setSeatId(showSeat.getSeat().getId())
                 .setShowId(showSeat.getShow().getId())
                 .setPrice(showSeat.getPrice());

         return responseDTO;
    }
}
