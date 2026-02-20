package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidSeatIdException extends BaseException {
    public InvalidSeatIdException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
