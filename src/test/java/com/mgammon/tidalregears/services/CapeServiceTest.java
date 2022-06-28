package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Cape;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class CapeServiceTest {

    @Autowired
    CapeService capeService;

    @Test
    public void testAddNewCape() {
        Cape cape1 = new Cape("Super Man");
        capeService.addNewCape(cape1);
        assertTrue(capeService.getCapes().contains(cape1));
    }
}
