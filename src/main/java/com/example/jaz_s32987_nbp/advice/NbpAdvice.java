package com.example.jaz_s32987_nbp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class NbpAdvice {
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleHttpClientErrorExceptionNotFound(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleHttpClientErrorExceptionBadRequest(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }
    /*@ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleHttpClientErrorExceptionNotFound(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }*/
}
