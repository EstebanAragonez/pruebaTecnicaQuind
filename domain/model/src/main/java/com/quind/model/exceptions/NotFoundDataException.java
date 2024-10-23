package com.quind.model.exceptions;

public class NotFoundDataException extends RuntimeException {

    public NotFoundDataException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFoundDataException(String message) {
        super(message);
    }
}
