package com.example.projects.ticTacToeSystemDesign.exceptions;

public class InvalidColumnException extends RuntimeException {
    public InvalidColumnException() {
        super();
    }

    public InvalidColumnException(String message) {
        super(message);
    }

    public InvalidColumnException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidColumnException(Throwable cause) {
        super(cause);
    }

    public InvalidColumnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
