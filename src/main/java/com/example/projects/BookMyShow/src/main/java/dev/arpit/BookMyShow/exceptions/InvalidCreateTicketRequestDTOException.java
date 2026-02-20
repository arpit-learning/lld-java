package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCreateTicketRequestDTOException extends BaseException {
    public InvalidCreateTicketRequestDTOException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
