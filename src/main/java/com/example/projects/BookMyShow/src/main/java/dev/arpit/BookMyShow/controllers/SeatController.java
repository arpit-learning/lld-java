package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateSeatRequestDTOException;
import dev.arpit.BookMyShow.mappers.SeatDTOMapper;
import dev.arpit.BookMyShow.models.Seat;
import dev.arpit.BookMyShow.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("/seat")
    public ResponseEntity<ResponseDTO<CreateSeatResponseDTO>> createSeat(@RequestBody CreateSeatRequestDTO requestDTO) {
        ResponseDTO<CreateSeatResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            Seat seat = SeatDTOMapper.getSeat(requestDTO);
            seat = seatService.save(seat);
            responseDTO.setData(
                    SeatDTOMapper.getCreateSeatResponseDTO(seat)
            ).setMeta(
                    new MetaDataDTO(
                            "success",
                            ResponseCode.SC_200,
                            "Seat created successfully"
                    )
            );
        } catch(BaseException e) {
            responseDTO.setMeta(new MetaDataDTO(
                    e.getMessage(),
                    e.getCode(),
                    e.getDisplayMessage()
            ));
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateSeatRequestDTO requestDTO) throws InvalidCreateSeatRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateSeatRequestDTOException("Request body can not be null", ResponseCode.ER_400, "Invalid request body");
        }
        if(requestDTO.getSeatNumber() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat number can not be null", ResponseCode.ER_400, "Invalid seat number");
        }
        if(requestDTO.getSeatRow() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat row can not be 0", ResponseCode.ER_400, "Invalid seat row");
        }
        if(requestDTO.getSeatColumn() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat column can not be 0", ResponseCode.ER_400, "Invalid seat column");
        }
        if(requestDTO.getSeatType() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat type can not be null", ResponseCode.ER_400, "Invalid seat type");
        }
    }
}
