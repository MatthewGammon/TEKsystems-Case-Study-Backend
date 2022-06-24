package com.mgammon.tidalregearsdemo.advice;

import com.mgammon.tidalregearsdemo.exceptions.*;
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
        return new ResponseEntity<>("No " + entityName + " found for the id: '" + entityId + "'.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExists(AlreadyExistsException alreadyExistsException) {
        String eventId = alreadyExistsException.getEventId();
        String entityName = alreadyExistsException.getEntityName();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Regear-Exists", "Regear Request already exists!");
        return new ResponseEntity<>(entityName + " with an id of '" + eventId + "' already exists!", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPropertyTypeException.class)
    public ResponseEntity<String> handleInvalidPropertyType(InvalidPropertyTypeException invalidPropertyTypeException) {
        String propertyType = invalidPropertyTypeException.getPropertyType();
        String expectedType = invalidPropertyTypeException.getExpectedType();
        return new ResponseEntity<>("Property must be of type " + expectedType + " , but received " + propertyType + ".", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidBuildException.class)
    public ResponseEntity<String> handleInvalidBuild(InvalidBuildException invalidBuildException) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Invalid-Build", "Invalid build. Please check the approved builds list.");
        return new ResponseEntity<>("Invalid gear equipped! Please check the approved builds list.", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemPowerTooLowException.class)
    public ResponseEntity<String> handleLowItemPower(ItemPowerTooLowException itemPowerTooLowException) {
        Integer itemPower = itemPowerTooLowException.getItemPower();
        Integer minimumIp = itemPowerTooLowException.getMinimumIp();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Item-Power", "Item power is too low!");
        return new ResponseEntity<>("Item power is too low! Your IP is " + itemPower + " and the minimum IP is " + minimumIp + ".", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TierTooLowException.class)
    public ResponseEntity<String> handleLowTier(TierTooLowException tierTooLowException) {
        Integer minimumTierEquiv = tierTooLowException.getMinimumTierEquiv();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Tier-Equiv", "Items do not meet minimum tier.");
        return new ResponseEntity<>("Item tier not high enough. Minimum tier equivalent is " + minimumTierEquiv + ".", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateBuildException.class)
    public ResponseEntity<String> handleDuplicateBuild(DuplicateBuildException duplicateBuildException) {
        return new ResponseEntity<>("A build with the given main hand, head, chest, shoes, minimum IP, and tier equivalent already exists.", HttpStatus.BAD_REQUEST);
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
