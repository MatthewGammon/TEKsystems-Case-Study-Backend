package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Head;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class HeadServiceTest {
    @Autowired
    HeadService headService;

    @Test
    public void testAddNewHeadGear() {
        Head head1 = new Head("Thinking Cap");
        headService.addNewHeadGear(head1);
        assertTrue(headService.getHeadGear().contains(head1));
    }
}
