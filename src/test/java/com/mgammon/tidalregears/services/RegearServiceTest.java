package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Build;
import com.mgammon.tidalregears.models.Regear;
import com.mgammon.tidalregears.repositories.BuildRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Transactional
public class RegearServiceTest {
    @Autowired
    RegearService regearService;

    @Autowired
    BuildRepository buildRepository;

    @Test
    public void testAddNewRegear() {
        Regear regearRequest = new Regear("pending", "CynicalEntity", "Tidal", "55566642069", 1420, "Bloodletter", "8.3", 11, "Mercenary Hood", "8.3", 11, "Cleric Robe", "8.3", 11, "Scholar Sandals", "8.3", 11, "today");
        Build testBuild = new Build("Cynical Fallen", "Healer", 8, 1350, "Mercenary Hood", "Cleric Robe", "Scholar Sandals", "Bloodletter", null, "Fort Sterling Cape", "Pork Omelette", "Resistance Potion", "Swiftclaw");
        buildRepository.save(testBuild);

        regearService.addNewRegear(regearRequest);
        assertTrue(regearService.getRegears().contains(regearRequest));
    }
}
