package com.mgammon.tidalregears.exceptions;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class ItemPowerTooLowException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer itemPower;

    private Integer minimumIp;

    public ItemPowerTooLowException(Integer itemPower, Integer minimumIp) {
        this.itemPower = itemPower;
        this.minimumIp = minimumIp;
    }

    public ItemPowerTooLowException() {
    }

    public Integer getItemPower() {
        return itemPower;
    }

    public void setItemPower(Integer itemPower) {
        this.itemPower = itemPower;
    }

    public Integer getMinimumIp() {
        return minimumIp;
    }

    public void setMinimumIp(Integer minimumIp) {
        this.minimumIp = minimumIp;
    }
}
