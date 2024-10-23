package com.quind.apirest.exceptions;

public record ErrorResponse(
         String message,
         int statusCode,
         String status
) {
}
