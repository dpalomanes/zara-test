package com.zara.challenge.exceptions;

import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;


@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<Object> handleNumberFormatException(RuntimeException ex, WebRequest request){
        String message = "Wrong product_id or brand_id.";
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {DateTimeParseException.class})
    public ResponseEntity<Object> handleDateTimeParseException(RuntimeException ex, WebRequest request){
        String message = "Wrong date format.";
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){
        String message = "The price for the product in the selected date could not be found.";
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> handleNotFoundException(NoSuchElementException ex, WebRequest request){
        String message = "More than one price found for the given parameters with the same priority.";
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
