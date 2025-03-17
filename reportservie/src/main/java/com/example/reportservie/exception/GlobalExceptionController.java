package com.example.reportservie.exception;

import java.io.IOException;

import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;

import com.example.reportservie.common.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler({InvalidInputException.class, BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InternalException.class, InternalServerError.class, IOException.class})
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "An unexpected error occurred: " + ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
