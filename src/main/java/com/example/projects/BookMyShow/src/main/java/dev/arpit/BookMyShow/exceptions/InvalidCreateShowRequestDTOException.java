package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCreateShowRequestDTOException extends BaseException {
    public InvalidCreateShowRequestDTOException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
