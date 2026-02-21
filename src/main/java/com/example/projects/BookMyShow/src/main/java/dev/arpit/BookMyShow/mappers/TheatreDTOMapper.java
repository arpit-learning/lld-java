package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateTheatreRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateTheatreResponseDTO;
import dev.arpit.BookMyShow.models.Theatre;

public class TheatreDTOMapper {
    public static Theatre getTheatre(CreateTheatreRequestDTO requestDTO) {
        Theatre theatre = new Theatre();
        theatre.setName(requestDTO.getName());
        theatre.setAddress(requestDTO.getAddress());
        return theatre;
    }

    public static CreateTheatreResponseDTO getCreateTheatreResponseDTO(Theatre theatre) {
        CreateTheatreResponseDTO responseDTO = new CreateTheatreResponseDTO();
        responseDTO.setId(theatre.getId());
        responseDTO.setName(theatre.getName());
        responseDTO.setAddress(theatre.getAddress());
        return responseDTO;
    }
}
