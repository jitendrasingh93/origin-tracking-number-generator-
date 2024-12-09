package com.tracking.generate.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handle(ConstraintViolationException exception) {
        List<String> errorList = exception.getConstraintViolations().stream()
                .map(v -> String.format("%s value '%s' %s", StreamSupport.stream(v.getPropertyPath().spliterator(), false)
                                .reduce((first, second) -> second).orElse(null), v.getInvalidValue(), v.getMessage()))
                .collect(Collectors.toList());
        ApiError apiError = new ApiError(errorList, 1000);
        return new ResponseEntity<>(apiError, null, HttpStatus.BAD_REQUEST);
    }
}
