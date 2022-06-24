package com.mgammon.tidalregearsdemo.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class TierTooLowException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer minimumTierEquiv;

    public TierTooLowException(Integer minimumTierEquiv) {
        this.minimumTierEquiv = minimumTierEquiv;
    }

    public TierTooLowException() {
    }

    public Integer getMinimumTierEquiv() {
        return minimumTierEquiv;
    }

    public void setMinimumTierEquiv(Integer minimumTierEquiv) {
        this.minimumTierEquiv = minimumTierEquiv;
    }
}
