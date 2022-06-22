package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table
public class OffHand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offHandId;

    @Column(nullable = false)
    private String offHandName;


    public OffHand(String offHandName) {
        this.offHandName = offHandName;
    }

    public OffHand() {
    }

    public Long getOffHandId() {
        return offHandId;
    }

    public void setOffHandId(Long offHandId) {
        this.offHandId = offHandId;
    }

    public String getOffHandName() {
        return offHandName;
    }

    public void setOffHandName(String offHandName) {
        this.offHandName = offHandName;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "gearId=" + offHandId +
                ", gearName='" + offHandName + '\'' +
                '}';
    }
}


