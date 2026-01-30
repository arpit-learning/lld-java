package com.example.projects.ticTacToeSystemDesign.exceptions;

public class DuplicateSymbolsException extends RuntimeException {
    public DuplicateSymbolsException() {
        super();
    }

    public DuplicateSymbolsException(String message) {
        super(message);
    }

    public DuplicateSymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateSymbolsException(Throwable cause) {
        super(cause);
    }

    public DuplicateSymbolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
