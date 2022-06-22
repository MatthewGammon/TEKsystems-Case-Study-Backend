package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "chest_gear")
public class Chest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chestId;

    @Column(nullable = false)
    private String chestName;

    public Chest(String chestName) {
        this.chestName = chestName;
    }

    public Chest() {
    }

    public Long getChestId() {
        return chestId;
    }

    public void setChestId(Long chestId) {
        this.chestId = chestId;
    }

    public String getChestName() {
        return chestName;
    }

    public void setChestName(String chestName) {
        this.chestName = chestName;
    }

    @Override
    public String toString() {
        return "Chest{" +
                "chestId=" + chestId +
                ", chestName='" + chestName + '\'' +
                '}';
    }
}
