package com.mgammon.tidalregearsdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "mounts")
public class Mount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mountId;
    @Column(nullable = false)
    private String mountName;

    public Mount(String mountName) {
        this.mountName = mountName;
    }

    public Mount() {
    }

    public Long getMountId() {
        return mountId;
    }

    public void setMountId(Long mountId) {
        this.mountId = mountId;
    }

    public String getMountName() {
        return mountName;
    }

    public void setMountName(String mountName) {
        this.mountName = mountName;
    }

    @Override
    public String toString() {
        return "Mount{" +
                "mountId=" + mountId +
                ", mountName='" + mountName + '\'' +
                '}';
    }
}


