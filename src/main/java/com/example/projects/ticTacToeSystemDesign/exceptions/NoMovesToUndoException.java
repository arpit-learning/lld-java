package com.example.projects.ticTacToeSystemDesign.exceptions;

public class NoMovesToUndoException extends RuntimeException {
    public NoMovesToUndoException() {
        super();
    }

    public NoMovesToUndoException(String message) {
        super(message);
    }

    public NoMovesToUndoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMovesToUndoException(Throwable cause) {
        super(cause);
    }

    public NoMovesToUndoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
