package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
