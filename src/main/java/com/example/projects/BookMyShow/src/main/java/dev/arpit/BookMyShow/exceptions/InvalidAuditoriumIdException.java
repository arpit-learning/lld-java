package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidAuditoriumIdException extends BaseException {
    public InvalidAuditoriumIdException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
