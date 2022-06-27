package com.mgammon.tidalregears.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;


@Component
public class DuplicateBuildException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateBuildException() {
    }
}
