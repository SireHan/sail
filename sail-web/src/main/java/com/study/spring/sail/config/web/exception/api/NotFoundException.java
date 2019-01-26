package com.study.spring.sail.config.web.exception.api;

/**
 * 404异常 exception
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
