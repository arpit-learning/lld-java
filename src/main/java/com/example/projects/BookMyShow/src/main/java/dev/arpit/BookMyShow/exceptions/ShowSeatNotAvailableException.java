package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class ShowSeatNotAvailableException extends BaseException {
    public ShowSeatNotAvailableException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
