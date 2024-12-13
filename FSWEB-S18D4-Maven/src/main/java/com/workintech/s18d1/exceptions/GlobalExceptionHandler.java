package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handlerException(BurgerException exception){
        log.error("burger exception occured! Exception details: ", exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }
    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handlerException(Exception exception){
        log.error("exception occured! Exception details: ", exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
