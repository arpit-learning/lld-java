package com.example.projects.ticTacToeSystemDesign.exceptions;

public class InvalidRowException extends RuntimeException {
    public InvalidRowException() {
        super();
    }

    public InvalidRowException(String message) {
        super(message);
    }

    public InvalidRowException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRowException(Throwable cause) {
        super(cause);
    }

    public InvalidRowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
