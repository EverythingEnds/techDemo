package com.example.techdemo.controllers.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Exception that throwing out in web API layer whenever handling exceptions in
 * "lower" layers
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
public class RestApiException extends RuntimeException {
    /**
     * map that contains any params of exception
     */
    @Getter
    private final Map<String, Object> parameters = new HashMap<>();

    /**
     * http response status that maps by exception type
     */
    @Getter
    private final HttpStatus status;

    public RestApiException(HttpStatus status) {
        this.status = status;
    }

    public RestApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        addParameter("message", message);
    }

    /**
     * Adding named exception parameter with value
     *
     * @param name  name of adding parameter
     * @param value value of adding value
     * @return modified rest API exception
     */
    public RestApiException addParameter(String name, Object value) {
        parameters.put(name, value);
        return this;
    }
}

