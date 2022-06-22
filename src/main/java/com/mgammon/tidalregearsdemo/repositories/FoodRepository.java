package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
