package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class InvalidCreateMovieRequestDTOException extends BaseException {
    public InvalidCreateMovieRequestDTOException(String message, ResponseCode code, String displayMessage) {
        super(message, code, displayMessage);
    }
}
