package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidMovieIdException extends BaseException {
    public InvalidMovieIdException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
