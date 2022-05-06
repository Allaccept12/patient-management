package com.example.patientmanagement.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionController {

    @ExceptionHandler(value = {CustomException.class,})
    public ResponseEntity<Fail> customErrorException(CustomException ex) {
        Fail apiException = new Fail(ex.getErrorCode());
        log.error("이셉션 로그 :" + ex.getErrorCode());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
