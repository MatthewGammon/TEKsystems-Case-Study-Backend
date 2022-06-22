package com.mgammon.tidalregearsdemo.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class NotFoundByIdException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long entityId;
    private String entityName;

    public NotFoundByIdException(Long entityId, String entityName) {
        this.entityId = entityId;
        this.entityName = entityName;
    }

    public NotFoundByIdException() {
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
