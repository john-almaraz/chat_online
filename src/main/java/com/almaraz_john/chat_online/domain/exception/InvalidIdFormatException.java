package com.almaraz_john.chat_online.domain.exception;

public class InvalidIdFormatException extends RuntimeException {
    public InvalidIdFormatException(String message) {
        super(message);
    }
}
