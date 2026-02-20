package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class ShowSeatsNotFoundException extends BaseException {
    public ShowSeatsNotFoundException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
