package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.CreateSeatRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateSeatResponseDTO;
import dev.arpit.BookMyShow.dtos.MetaDataDTO;
import dev.arpit.BookMyShow.dtos.ResponseDTO;
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
                            "SUCCESS"
                    )
            );
        } catch(Exception e) {
            responseDTO.setMeta(new MetaDataDTO(
                    e.getMessage(),
                    "FAILURE"
            ));
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateSeatRequestDTO requestDTO) throws InvalidCreateSeatRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateSeatRequestDTOException("Request body can not be null");
        }
        if(requestDTO.getSeatNumber() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat number can not be null");
        }
        if(requestDTO.getSeatRow() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat row can not be 0");
        }
        if(requestDTO.getSeatColumn() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat column can not be 0");
        }
        if(requestDTO.getSeatType() == null) {
            throw new InvalidCreateSeatRequestDTOException("Seat type can not be null");
        }
    }
}
