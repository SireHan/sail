package com.study.spring.sail.config.web.handler;

import com.study.spring.sail.config.web.exception.api.BadRequestException;
import com.study.spring.sail.config.web.exception.api.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * rest请求异常拦截 handler
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@ControllerAdvice
public class RestExceptionHandle extends ResponseEntityExceptionHandler {

    /**
     * 错误请求处理
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handlerBadRequest(Exception e, WebRequest request) {
        return handleExceptionInternal(e, e.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * 资源找不到请求处理
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Resource not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
