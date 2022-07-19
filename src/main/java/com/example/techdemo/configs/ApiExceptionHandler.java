package com.example.techdemo.configs;

import com.example.techdemo.controllers.exceptions.RestApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Exception handler that processing REST API and unhandled exceptions to
 * make rest api response with exception message, also logs details. Details doesnt
 * sending in response because of security purposes.
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * Process REST API exceptions
     * @param e thrown exception
     * @return response entity with error message
     */
    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<String> handleException(RestApiException e) {
        log.error("RestApiException: [ " + e.getStatus() + " ] " + e.getParameters().toString());
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }

    /**
     * Process unhandled exceptions
     *
     * @param e thrown exception
     * @return response entity with error message
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.TEXT_PLAIN)
                .body(e.getMessage());
    }

}

