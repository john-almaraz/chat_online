package com.almaraz_john.chat_online.infrastructure.adapters.exception;

import com.almaraz_john.chat_online.domain.exception.ConversationNotFoundException;
import com.almaraz_john.chat_online.domain.exception.InvalidIdFormatException;
import com.almaraz_john.chat_online.domain.exception.UserNotFoundException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Getter
    public static class ErrorResponse {
        private final String message;
        private final long timestamp;

        public ErrorResponse(String message) {
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }

    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(InvalidIdFormatException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleInvalidIdFormatException(InvalidIdFormatException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(ConversationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleConversationNotFoundException(ConversationNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}
