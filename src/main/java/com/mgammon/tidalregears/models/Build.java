package com.mgammon.tidalregears.models;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "builds")
@EqualsAndHashCode
public class Build {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildId;

    @Column(nullable = false)
    private String buildName;

    @Column(nullable = false)
    private String buildRole;

    @Column(nullable = false)
    private int minimumTier;

    @Column(nullable = false)
    private int minimumIp;

    @Column(nullable = false)
    private String headGear;

    @Column(nullable = false)
    private String chestGear;

    @Column(nullable = false)
    private String shoes;

    @Column(nullable = false)
    private String mainHand;

    @Column(nullable = true)
    private String offHand;

    @Column(nullable = false)
    private String cape;

    @Column(nullable = false)
    private String food;

    @Column(nullable = false)
    private String potion;

    @Column(nullable = false)
    private String mount;

    public Build(String buildName, String buildRole, int minimumTier, int minimumIp, String headGear, String chestGear, String shoes, String mainHand, String offHand, String cape, String food, String potion, String mount) {
        this.buildName = buildName;
        this.buildRole = buildRole;
        this.minimumTier = minimumTier;
        this.minimumIp = minimumIp;
        this.headGear = headGear;
        this.chestGear = chestGear;
        this.shoes = shoes;
        this.mainHand = mainHand;
        this.offHand = offHand;
        this.cape = cape;
        this.food = food;
        this.potion = potion;
        this.mount = mount;
    }

    public Build() {
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildRole() {
        return buildRole;
    }

    public void setBuildRole(String buildRole) {
        this.buildRole = buildRole;
    }

    public int getMinimumTier() {
        return minimumTier;
    }

    public void setMinimumTier(int minimumTier) {
        this.minimumTier = minimumTier;
    }

    public int getMinimumIp() {
        return minimumIp;
    }

    public void setMinimumIp(int minimumIp) {
        this.minimumIp = minimumIp;
    }

    public String getHeadGear() {
        return headGear;
    }

    public void setHeadGear(String headGear) {
        this.headGear = headGear;
    }

    public String getChestGear() {
        return chestGear;
    }

    public void setChestGear(String chestGear) {
        this.chestGear = chestGear;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getMainHand() {
        return mainHand;
    }

    public void setMainHand(String mainHand) {
        this.mainHand = mainHand;
    }

    public String getOffHand() {
        return offHand;
    }

    public void setOffHand(String offHand) {
        this.offHand = offHand;
    }

    public String getCape() {
        return cape;
    }

    public void setCape(String cape) {
        this.cape = cape;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    @Override
    public String toString() {
        return "Build{" +
                "buildId=" + buildId +
                ", buildName='" + buildName + '\'' +
                ", buildRole='" + buildRole + '\'' +
                ", minimumTier=" + minimumTier +
                ", minimumIp=" + minimumIp +
                ", headGear='" + headGear + '\'' +
                ", chestGear='" + chestGear + '\'' +
                ", shoes='" + shoes + '\'' +
                ", mainHand='" + mainHand + '\'' +
                ", offHand='" + offHand + '\'' +
                ", cape='" + cape + '\'' +
                ", food='" + food + '\'' +
                ", potion='" + potion + '\'' +
                ", mount='" + mount + '\'' +
                '}';
    }
}
