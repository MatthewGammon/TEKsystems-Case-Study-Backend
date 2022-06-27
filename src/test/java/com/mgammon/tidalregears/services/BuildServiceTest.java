package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Build;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class BuildServiceTest {


    @Autowired
    BuildService buildService;


    @Test
    public void testAddNewBuild() {
        Build testBuild = new Build("Cynical Fallen", "Healer", 8, 1350, "Mercenary Hood", "Demon Armor", "Druid Sandals", "Bloodletter", null, "Fort Sterling Cape", "Pork Omelette", "Resistance Potion", "Swiftclaw");
        buildService.addNewBuild(testBuild);
        assertTrue(buildService.getBuilds().contains(testBuild));
    }
}
