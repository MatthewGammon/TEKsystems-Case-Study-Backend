package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Shoe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class ShoeServiceTest {
    @Autowired
    ShoeService shoeService;

    @Test
    public void testAddNewShoe() {
        Shoe shoe1 = new Shoe("Chuck Taylors");
        shoeService.addNewShoes(shoe1);
        assertTrue(shoeService.getShoes().contains(shoe1));
    }
}
