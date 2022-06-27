package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Mount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class MountServiceTest {
    @Autowired
    MountService mountService;

    @Test
    public void testAddNewMount() {
        Mount mount1 = new Mount("Chocobo");
        mountService.addNewMount(mount1);
        assertTrue(mountService.getMounts().contains(mount1));
    }
}
