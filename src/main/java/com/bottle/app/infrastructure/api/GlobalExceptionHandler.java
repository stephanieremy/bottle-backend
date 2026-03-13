package com.bottle.app.infrastructure.api;

import com.bottle.app.domain.BottleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BottleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBottleNotFoundException(BottleNotFoundException ex) {
        return ex.getMessage();
    }
}