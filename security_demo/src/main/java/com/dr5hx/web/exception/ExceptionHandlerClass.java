package com.dr5hx.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常切面
 */
@ControllerAdvice(value = "com.dr5hx.web.controller")
public class ExceptionHandlerClass {
    @ExceptionHandler(Exception.class)
    public void getException(Exception ex) {
        System.out.println("ControllerAdvice show the exception:" + ex.getMessage());
    }
}
