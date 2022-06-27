package com.mgammon.tidalregears.models;

import javax.persistence.*;

@Entity
@Table(name = "potions")
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long potionId;
    @Column(nullable = false)
    private String potionName;

    public Potion(String potionName) {
        this.potionName = potionName;
    }

    public Potion() {
    }

    public Long getPotionId() {
        return potionId;
    }

    public void setPotionId(Long potionId) {
        this.potionId = potionId;
    }

    public String getPotionName() {
        return potionName;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "potionId=" + potionId +
                ", potionName='" + potionName + '\'' +
                '}';
    }
}
