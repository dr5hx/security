package com.dr5hx.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(value = "com.dr5hx.controller")
public class ExceptionHandlerClass {
    @ExceptionHandler(Exception.class)
    public void getException(Exception ex) {
        System.out.println("ControllerAdvice show the exception:" + ex.getMessage());
    }
}
