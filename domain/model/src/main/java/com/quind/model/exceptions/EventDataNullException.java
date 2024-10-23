package com.quind.model.exceptions;

public class EventDataNullException extends IllegalArgumentException {

    public static final String MESSAGE_DATA_NULL = "Error de datos nulos en el evento al procesar mensaje";

    public EventDataNullException(String message) {
        super(message);
    }
}