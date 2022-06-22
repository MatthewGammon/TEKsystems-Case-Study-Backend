package com.mgammon.tidalregearsdemo.advice;

import com.mgammon.tidalregearsdemo.exceptions.InvalidPropertyTypeException;
import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundByIdException.class)
    public ResponseEntity<String> handleNotFoundById(NotFoundByIdException notFoundByIdException) {
        Long entityId = notFoundByIdException.getEntityId();
        String entityName = notFoundByIdException.getEntityName();
        return new ResponseEntity<String>("No " + entityName + " found for the id: '" + entityId + "'.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPropertyTypeException.class)
    public ResponseEntity<String> handleInvalidPropertyType(InvalidPropertyTypeException invalidPropertyTypeException) {
        String propertyType = invalidPropertyTypeException.getPropertyType();
        String expectedType = invalidPropertyTypeException.getExpectedType();
        return new ResponseEntity<String>("Property must be of type " + expectedType + " , but received " + propertyType + ".", HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Method not allowed for this resource. Please check your request method and try again.", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Unable to read request body. Body may be empty or not formatted properly. Please check your request and try again.", HttpStatus.BAD_REQUEST);

    }
}
