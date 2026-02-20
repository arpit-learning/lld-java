package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateShowSeatRequestDTOException;
import dev.arpit.BookMyShow.mappers.ShowSeatDTOMapper;
import dev.arpit.BookMyShow.models.ShowSeat;
import dev.arpit.BookMyShow.services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowSeatController {
    @Autowired
    private ShowSeatService showSeatService;

    @PostMapping("/show-seat")
    public ResponseEntity<ResponseDTO<CreateShowSeatResponseDTO>> crateShowSeat(@RequestBody CreateShowSeatRequestDTO requestDTO) {
        ResponseDTO<CreateShowSeatResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            int showId = requestDTO.getShowId();
            int seatId = requestDTO.getSeatId();
            double price = requestDTO.getPrice();
            ShowSeat showSeat = showSeatService.createShowSeat(showId,seatId,price);
            responseDTO.setData(
                    ShowSeatDTOMapper.getCreateShowSeatResponseDTO(showSeat)
            ).setMeta(
                    new MetaDataDTO(
                            "success",
                            ResponseCode.SC_200,
                            "ShowSeat created successfully"
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

    private void doValidations(CreateShowSeatRequestDTO requestDTO) throws InvalidCreateShowSeatRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateShowSeatRequestDTOException("request data can not be null.", ResponseCode.ER_400, "Invalid request data");
        }
        if(requestDTO.getSeatId() == null) {
            throw new InvalidCreateShowSeatRequestDTOException("SeatId can not be null.", ResponseCode.ER_400, "Invalid SeatId");
        }
        if(requestDTO.getShowId() == null) {
            throw new InvalidCreateShowSeatRequestDTOException("ShowId can not be null.", ResponseCode.ER_400, "Invalid ShowId");
        }
        if(requestDTO.getPrice() == null) {
            throw new InvalidCreateShowSeatRequestDTOException("Price can not be null.", ResponseCode.ER_400, "Invalid Price");
        }
    }
}
