package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.dtos.*;
import dev.arpit.BookMyShow.exceptions.BaseException;
import dev.arpit.BookMyShow.exceptions.InvalidCreateTicketRequestDTOException;
import dev.arpit.BookMyShow.mappers.TicketDTOMapper;
import dev.arpit.BookMyShow.models.Ticket;
import dev.arpit.BookMyShow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity<ResponseDTO<CreateTicketResponseDTO>> createTicket(@RequestBody CreateTicketRequestDTO requestDTO) {
        ResponseDTO<CreateTicketResponseDTO> responseDTO = new ResponseDTO<>();

        try {
            doValidations(requestDTO);
            List<Integer> showSeatIds = requestDTO.getShowSeatIds();
            int userId = requestDTO.getUserId();

            Ticket ticket = ticketService.createTicket(showSeatIds, userId);
            responseDTO.setData(TicketDTOMapper.getTicketResponseDTO(ticket));
            responseDTO.setMeta(new MetaDataDTO(
                    "Success",
                    ResponseCode.SC_200,
                    "Ticket created successfully"
            ));
        } catch(BaseException e) {
            responseDTO.setMeta(new MetaDataDTO(
                    e.getMessage(),
                    e.getCode(),
                    e.getDisplayMessage()
            ));
        }

        return ResponseEntity.ok(responseDTO);
    }

    private void doValidations(CreateTicketRequestDTO requestDTO) throws InvalidCreateTicketRequestDTOException {
        if(requestDTO == null) {
            throw new InvalidCreateTicketRequestDTOException("Request payload can not be null", ResponseCode.ER_400, "Invalid request payload");
        }
        if(requestDTO.getShowSeatIds() == null || requestDTO.getShowSeatIds().isEmpty()) {
            throw new InvalidCreateTicketRequestDTOException("ShowSeatIds can not be empty", ResponseCode.ER_400, "Invalid ShowSeatIds");
        }
        if(requestDTO.getUserId() == 0) {
            throw new InvalidCreateTicketRequestDTOException("UserId can not be empty", ResponseCode.ER_400, "Invalid UserId");
        }
        for(Integer seatId : requestDTO.getShowSeatIds()) {
            if(seatId == null) {
                throw new InvalidCreateTicketRequestDTOException("ShowSeatIds can not contain null values", ResponseCode.ER_400, "Invalid ShowSeatIds");
            }
        }
    }
}
