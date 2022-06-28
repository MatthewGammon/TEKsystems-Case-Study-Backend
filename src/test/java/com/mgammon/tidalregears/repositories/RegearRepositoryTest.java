package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Regear;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class RegearRepositoryTest {

    @Autowired
    RegearRepository regearRepository;

    @Test
    public void testFindByEventId() {
        String eventId = "492985911";
        Regear foundRegear = regearRepository.findByEventId(eventId);
        assertNotNull(foundRegear);
    }
}
