package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.MainHand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class MainHandServiceTest {

    @Autowired
    MainHandService mainHandService;

    @Test
    public void testAddMainHand() {
        MainHand mainHand1 = new MainHand("Rusty Knife");
        mainHandService.addNewMainHand(mainHand1);
        assertTrue(mainHandService.getMainHand().contains(mainHand1));
    }

}
