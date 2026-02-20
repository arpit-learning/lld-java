package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCreateShowSeatRequestDTOException extends BaseException {
    public InvalidCreateShowSeatRequestDTOException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
