package com.example.managementstore.exception;

import com.example.managementstore.domain.UnknownObjectException;
import com.example.managementstore.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.Optional;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UnknownObjectException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(UnknownObjectException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value(),
                LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

}
