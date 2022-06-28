package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class FoodServiceTest {
    @Autowired
    FoodService foodService;


    @Test
    public void testAddNewFood() {
        Food food1 = new Food("Jack's Special Waffles");
        foodService.addNewFood(food1);
        assertTrue(foodService.getFood().contains(food1));
    }
}
