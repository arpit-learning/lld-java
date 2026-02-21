package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCityIdException extends BaseException {
    public InvalidCityIdException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
