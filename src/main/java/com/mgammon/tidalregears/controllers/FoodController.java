package com.mgammon.tidalregears.controllers;

import com.mgammon.tidalregears.models.Food;
import com.mgammon.tidalregears.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getFood() {
        return foodService.getFood();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewFood(@RequestBody Food food) {
        foodService.addNewFood(food);
    }

    @GetMapping("{foodId}")
    public Optional<Food> getFoodById(@PathVariable Long foodId) {
        return foodService.findFoodById(foodId);
    }
}
