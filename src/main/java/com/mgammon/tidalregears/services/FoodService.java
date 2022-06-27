package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.Food;
import com.mgammon.tidalregears.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFood() {
        return foodRepository.findAll();
    }

    public void addNewFood(Food food) {
        foodRepository.save(food);
    }

    public Optional<Food> findFoodById(Long foodId) {
        if (foodRepository.findById(foodId).isEmpty()) {
            String entityName = "food";
            throw new NotFoundByIdException(foodId, entityName);
        }
        return foodRepository.findById(foodId);
    }
}
