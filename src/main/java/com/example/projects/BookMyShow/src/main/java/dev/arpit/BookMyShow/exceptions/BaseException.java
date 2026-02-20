package dev.arpit.BookMyShow.exceptions;

import dev.arpit.BookMyShow.dtos.ResponseCode;

public class BaseException extends Exception {
    private ResponseCode code;
    private String displayMessage;

    public BaseException(String message, ResponseCode code, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ResponseCode getCode() {
        return code;
    }

    public BaseException setCode(ResponseCode code) {
        this.code = code;
        return this;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public BaseException setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
        return this;
    }
}
