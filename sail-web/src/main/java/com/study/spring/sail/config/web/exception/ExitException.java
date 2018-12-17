package com.study.spring.sail.config.web.exception;

import org.springframework.boot.ExitCodeGenerator;

public class ExitException extends RuntimeException implements ExitCodeGenerator {
    public ExitException() {
        super();
    }

    public ExitException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getExitCode() {
        return 42;
    }
}
