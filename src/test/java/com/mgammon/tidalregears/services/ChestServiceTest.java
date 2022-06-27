package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Chest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class ChestServiceTest {

    @Autowired
    ChestService chestService;


    @Test
    public void testAddNewChestGear() {
        Chest chest1 = new Chest("Superior Breastplate");
        chestService.addNewChestGear(chest1);
        assertTrue(chestService.getChestGear().contains(chest1));
    }
}
