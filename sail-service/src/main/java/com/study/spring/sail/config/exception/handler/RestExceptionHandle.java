package com.study.spring.sail.config.exception.handler;

import com.study.spring.sail.config.exception.api.BadRequestException;
import com.study.spring.sail.config.exception.api.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandle extends ResponseEntityExceptionHandler {

    /**
     * 错误请求处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handlerBadRequest(Exception e, WebRequest request){
        return handleExceptionInternal(e,e.getLocalizedMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }

    /**
     * 资源找不到请求处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Resource not found",new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
