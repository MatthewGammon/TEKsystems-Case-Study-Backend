package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.OffHand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class OffHandServiceTest {
    @Autowired
    OffHandService offHandService;

    @Test
    public void testAddNewOffHand() {
        OffHand offHand1 = new OffHand("Katara");
        offHandService.addNewOffHand(offHand1);
        assertTrue(offHandService.getOffHand().contains(offHand1));
    }
}
