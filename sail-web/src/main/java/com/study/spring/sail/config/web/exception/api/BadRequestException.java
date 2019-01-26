package com.study.spring.sail.config.web.exception.api;

/**
 * 错误请求异常 exception
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException() {
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
