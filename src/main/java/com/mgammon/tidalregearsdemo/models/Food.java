package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    @Column(nullable = false)
    private String foodName;

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public Food() {
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
