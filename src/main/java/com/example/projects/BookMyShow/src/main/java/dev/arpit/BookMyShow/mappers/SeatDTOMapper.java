package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateSeatRequestDTO;
import dev.arpit.BookMyShow.dtos.CreateSeatResponseDTO;
import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidCreateSeatRequestDTOException;
import dev.arpit.BookMyShow.models.Seat;
import dev.arpit.BookMyShow.models.constants.SeatReservationType;
import dev.arpit.BookMyShow.models.constants.SeatStatus;
import dev.arpit.BookMyShow.models.constants.SeatType;

import java.util.Arrays;

public class SeatDTOMapper {
    public static Seat getSeat(CreateSeatRequestDTO requestDTO) throws InvalidCreateSeatRequestDTOException {
        Seat seat = new Seat();
        seat.setSeatNumber(requestDTO.getSeatNumber())
                .setRow(requestDTO.getSeatRow())
                .setColumn(requestDTO.getSeatColumn());
        if(Arrays.stream(SeatType.values()).noneMatch(i -> i.toString().equals(requestDTO.getSeatType()))) {
            throw new InvalidCreateSeatRequestDTOException("Invalid seat type", ResponseCode.ER_400, "Invalid seat type");
        }
        seat.setSeatType(SeatType.valueOf(requestDTO.getSeatType()));
        String reservationType = requestDTO.getSeatReservationType();
        if (!(reservationType == null || reservationType.trim().isEmpty())) {
            if (Arrays.stream(SeatReservationType.values()).noneMatch(i -> i.toString().equals(reservationType))) {
                throw new InvalidCreateSeatRequestDTOException("Invalid seat reservation type", ResponseCode.ER_400, "Invalid seat reservation type");
            }
            seat.setSeatReservationType(SeatReservationType.valueOf(reservationType));
        }
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        return seat;
    }

    public static CreateSeatResponseDTO getCreateSeatResponseDTO(Seat seat) {
        CreateSeatResponseDTO responseDTO = new CreateSeatResponseDTO();
        responseDTO.setId(seat.getId())
                .setSeatNumber(seat.getSeatNumber())
                .setSeatRow(seat.getRow())
                .setSeatColumn(seat.getColumn())
                .setSeatType(seat.getSeatType().toString())
                .setSeatStatus(seat.getSeatStatus().toString());
        if(seat.getSeatReservationType() != null) {
            responseDTO.setSeatReservationType(seat.getSeatReservationType().toString());
        }
        return responseDTO;
    }
}
