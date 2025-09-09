package com.kara.productserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse res = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), ex.getStackTrace().toString(), 500);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Entity bulunamadığında
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(NoSuchElementException ex) {
        ErrorResponse res = new ErrorResponse(LocalDateTime.now(), "Data not Found ", ex.getStackTrace().toString(), 404);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    // Validation hataları
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        ErrorResponse res = new ErrorResponse(LocalDateTime.now(),
                "invalid entity value or empty entity value",
                ex.getStackTrace().toString(),
                400);
        ;
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // IllegalArgumentException için (örneğin id geçersiz format)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse res = new ErrorResponse(LocalDateTime.now(), "Bad Request ", ex.getStackTrace().toString(), null);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
