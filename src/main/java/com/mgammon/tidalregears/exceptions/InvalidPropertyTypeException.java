package com.mgammon.tidalregears.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class InvalidPropertyTypeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String propertyType;
    private String expectedType;

    public InvalidPropertyTypeException(String propertyType, String expectedType) {
        this.propertyType = propertyType;
        this.expectedType = expectedType;
    }

    public InvalidPropertyTypeException() {
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getExpectedType() {
        return expectedType;
    }

    public void setExpectedType(String expectedType) {
        this.expectedType = expectedType;
    }
}
