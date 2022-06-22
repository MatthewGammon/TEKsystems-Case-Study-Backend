package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoeId;
    @Column(nullable = false)
    private String shoeName;

    public Shoe(String shoeName) {
        this.shoeName = shoeName;
    }

    public Shoe() {
    }

    public Long getShoeId() {
        return shoeId;
    }

    public void setShoeId(Long shoeId) {
        this.shoeId = shoeId;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "shoeId=" + shoeId +
                ", shoeName='" + shoeName + '\'' +
                '}';
    }
}
