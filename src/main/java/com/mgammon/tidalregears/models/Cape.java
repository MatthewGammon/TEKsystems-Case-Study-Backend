package com.mgammon.tidalregears.models;

import javax.persistence.*;

@Entity
@Table (name = "capes")
public class Cape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long capeId;

    @Column(nullable = false)
    private String capeName;

    public Cape(String capeName) {
        this.capeName = capeName;
    }

    public Cape() {
    }

    public Long getCapeId() {
        return capeId;
    }

    public void setCapeId(Long capeId) {
        this.capeId = capeId;
    }

    public String getCapeName() {
        return capeName;
    }

    public void setCapeName(String capeName) {
        this.capeName = capeName;
    }

    @Override
    public String toString() {
        return "Capes{" +
                "capeId=" + capeId +
                ", capeName='" + capeName + '\'' +
                '}';
    }
}
