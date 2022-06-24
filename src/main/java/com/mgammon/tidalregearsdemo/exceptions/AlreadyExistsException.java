package com.mgammon.tidalregearsdemo.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class AlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private String entityName;
    private String eventId;

    public AlreadyExistsException(String entityName, String eventId) {
        this.entityName = entityName;
        this.eventId = eventId;
    }

    public AlreadyExistsException() {
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
