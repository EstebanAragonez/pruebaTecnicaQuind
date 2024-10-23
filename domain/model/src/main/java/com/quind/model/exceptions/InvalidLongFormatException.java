package com.quind.model.exceptions;

public class InvalidLongFormatException extends RuntimeException{

    public InvalidLongFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidLongFormatException(String message) {
        super(message);
    }

}