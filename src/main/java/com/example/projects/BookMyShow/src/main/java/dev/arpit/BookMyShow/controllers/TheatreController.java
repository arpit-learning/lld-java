package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateTheatreRequestDTOException;
import dev.arpit.BookMyShow.mappers.TheatreDTOMapper;
import dev.arpit.BookMyShow.models.Theatre;
import dev.arpit.BookMyShow.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatre")
    public ResponseEntity<ResponseDTO<CreateTheatreResponseDTO>> createTheatre(@RequestBody CreateTheatreRequestDTO requestDTO) {
        ResponseDTO<CreateTheatreResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);

            Theatre theatre = TheatreDTOMapper.getTheatre(requestDTO);
            theatre = theatreService.save(theatre);
            responseDTO.setData(
                    TheatreDTOMapper.getCreateTheatreResponseDTO(theatre)
            ).setMeta(
                    new MetaDataDTO(
                            "success",
                            ResponseCode.SC_200,
                            "Theatre created successfully"
                    )
            );
        } catch(BaseException e) {
            responseDTO.setMeta(
                new MetaDataDTO(
                    e.getMessage(),
                    e.getCode(),
                    e.getDisplayMessage()
                )
            );
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateTheatreRequestDTO requestDTO) throws InvalidCreateTheatreRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateTheatreRequestDTOException("Request body can not be null", ResponseCode.ER_400, "Invalid request body");
        }
        if(requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            throw new InvalidCreateTheatreRequestDTOException("Theatre name can not be empty", ResponseCode.ER_400, "Invalid theatre name");
        }
    }
}
