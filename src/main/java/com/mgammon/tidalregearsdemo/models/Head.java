package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "head_gear")
public class Head {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headId;

    @Column(nullable = false)
    private String headName;

    public Head(String headName) {
        this.headName = headName;
    }

    public Head() {
    }

    public Long getHeadId() {
        return headId;
    }

    public void setHeadId(Long headId) {
        this.headId = headId;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    @Override
    public String toString() {
        return "Head{" +
                "headId=" + headId +
                ", headName='" + headName + '\'' +
                '}';
    }
}
