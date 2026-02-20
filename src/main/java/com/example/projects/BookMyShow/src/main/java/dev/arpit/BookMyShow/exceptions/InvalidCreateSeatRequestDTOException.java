package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCreateSeatRequestDTOException extends BaseException {
    public InvalidCreateSeatRequestDTOException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
