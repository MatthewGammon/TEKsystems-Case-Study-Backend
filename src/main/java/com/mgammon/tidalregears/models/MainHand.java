package com.mgammon.tidalregears.models;

import javax.persistence.*;

@Entity
@Table
public class MainHand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainHandId;
    @Column(nullable = false)
    private String mainHandName;

    public MainHand(String mainHandName) {
        this.mainHandName = mainHandName;
    }

    public MainHand() {
    }

    public Long getMainHandId() {
        return mainHandId;
    }

    public void setMainHandId(Long mainHandId) {
        this.mainHandId = mainHandId;
    }

    public String getMainHandName() {
        return mainHandName;
    }

    public void setMainHandName(String mainHandName) {
        this.mainHandName = mainHandName;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponId=" + mainHandId +
                ", weaponName='" + mainHandName + '\'' +
                '}';
    }
}
