package com.mgammon.tidalregearsdemo.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class InvalidBuildException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

   public InvalidBuildException(){}
}
