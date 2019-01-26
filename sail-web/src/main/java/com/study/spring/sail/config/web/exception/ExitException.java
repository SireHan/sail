package com.study.spring.sail.config.web.exception;

import org.springframework.boot.ExitCodeGenerator;

/**
 * 启动退出异常 exception
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
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
