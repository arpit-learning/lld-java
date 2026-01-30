package com.example.projects.ticTacToeSystemDesign.exceptions;

public class DrawGameException extends RuntimeException {
    public DrawGameException() {
        super();
    }

    public DrawGameException(String message) {
        super(message);
    }

    public DrawGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DrawGameException(Throwable cause) {
        super(cause);
    }

    public DrawGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
