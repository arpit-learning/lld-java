package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidShowIdException extends BaseException {
    public InvalidShowIdException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
