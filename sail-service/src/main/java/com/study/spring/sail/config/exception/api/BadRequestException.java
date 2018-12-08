package com.study.spring.sail.config.exception.api;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
