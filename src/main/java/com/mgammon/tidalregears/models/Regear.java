package com.mgammon.tidalregears.models;

import javax.persistence.*;

@Entity
@Table(name = "regears")
public class Regear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regearId;

    @Column
    private String status = "pending";

    @Column(nullable = false)
    private String characterName;

    @Column(nullable = false)
    private String guildName;

    @Column(nullable = false)
    private String eventId;

    @Column(nullable = false)
    private Integer itemPower;

    @Column(nullable = false)
    private String mainHand;

    @Column(nullable = false)
    private String mainTier;

    @Column(nullable = false)
    private Integer mainEquivalent;

    @Column(nullable = false)
    private String headGear;

    @Column(nullable = false)
    private String headTier;

    @Column(nullable = false)
    private Integer headEquivalent;

    @Column(nullable = false)
    private String chestGear;

    @Column(nullable = false)
    private String chestTier;

    @Column(nullable = false)
    private Integer chestEquivalent;

    @Column(nullable = false)
    private String shoes;

    @Column(nullable = false)
    private String shoesTier;

    @Column(nullable = false)
    private Integer shoesEquivalent;

    @Column(nullable = false)
    private String timeOfDeath;

    public Regear(String status, String characterName, String guildName, String eventId, Integer itemPower, String mainHand, String mainTier, Integer mainEquivalent, String headGear, String headTier, Integer headEquivalent, String chestGear, String chestTier, Integer chestEquivalent, String shoes, String shoesTier, Integer shoesEquivalent, String timeOfDeath) {
        this.status = status;
        this.characterName = characterName;
        this.guildName = guildName;
        this.eventId = eventId;
        this.itemPower = itemPower;
        this.mainHand = mainHand;
        this.mainTier = mainTier;
        this.mainEquivalent = mainEquivalent;
        this.headGear = headGear;
        this.headTier = headTier;
        this.headEquivalent = headEquivalent;
        this.chestGear = chestGear;
        this.chestTier = chestTier;
        this.chestEquivalent = chestEquivalent;
        this.shoes = shoes;
        this.shoesTier = shoesTier;
        this.shoesEquivalent = shoesEquivalent;
        this.timeOfDeath = timeOfDeath;
    }

    public Regear() {
    }

    public Long getRegearId() {
        return regearId;
    }

    public void setRegearId(Long regearId) {
        this.regearId = regearId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getItemPower() {
        return itemPower;
    }

    public void setItemPower(Integer itemPower) {
        this.itemPower = itemPower;
    }

    public String getMainHand() {
        return mainHand;
    }

    public void setMainHand(String mainHand) {
        this.mainHand = mainHand;
    }

    public String getMainTier() {
        return mainTier;
    }

    public void setMainTier(String mainTier) {
        this.mainTier = mainTier;
    }

    public Integer getMainEquivalent() {
        return mainEquivalent;
    }

    public void setMainEquivalent(Integer mainEquivalent) {
        this.mainEquivalent = mainEquivalent;
    }

    public String getHeadGear() {
        return headGear;
    }

    public void setHeadGear(String headGear) {
        this.headGear = headGear;
    }

    public String getHeadTier() {
        return headTier;
    }

    public void setHeadTier(String headTier) {
        this.headTier = headTier;
    }

    public Integer getHeadEquivalent() {
        return headEquivalent;
    }

    public void setHeadEquivalent(Integer headEquivalent) {
        this.headEquivalent = headEquivalent;
    }

    public String getChestGear() {
        return chestGear;
    }

    public void setChestGear(String chestGear) {
        this.chestGear = chestGear;
    }

    public String getChestTier() {
        return chestTier;
    }

    public void setChestTier(String chestTier) {
        this.chestTier = chestTier;
    }

    public Integer getChestEquivalent() {
        return chestEquivalent;
    }

    public void setChestEquivalent(Integer chestEquivalent) {
        this.chestEquivalent = chestEquivalent;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getShoesTier() {
        return shoesTier;
    }

    public void setShoesTier(String shoesTier) {
        this.shoesTier = shoesTier;
    }

    public Integer getShoesEquivalent() {
        return shoesEquivalent;
    }

    public void setShoesEquivalent(Integer shoesEquivalent) {
        this.shoesEquivalent = shoesEquivalent;
    }

    public String getTimeOfDeath() {
        return timeOfDeath;
    }

    public void setTimeOfDeath(String timeOfDeath) {
        this.timeOfDeath = timeOfDeath;
    }

    @Override
    public String toString() {
        return "Regear{" +
                "regearId=" + regearId +
                ", status='" + status + '\'' +
                ", characterName='" + characterName + '\'' +
                ", guildName='" + guildName + '\'' +
                ", eventId='" + eventId + '\'' +
                ", itemPower=" + itemPower +
                ", mainHand='" + mainHand + '\'' +
                ", mainTier='" + mainTier + '\'' +
                ", mainEquivalent=" + mainEquivalent +
                ", headGear='" + headGear + '\'' +
                ", headTier='" + headTier + '\'' +
                ", headEquivalent=" + headEquivalent +
                ", chestGear='" + chestGear + '\'' +
                ", chestTier='" + chestTier + '\'' +
                ", chestEquivalent=" + chestEquivalent +
                ", shoes='" + shoes + '\'' +
                ", shoesTier='" + shoesTier + '\'' +
                ", shoesEquivalent=" + shoesEquivalent +
                ", timeOfDeath='" + timeOfDeath + '\'' +
                '}';
    }
}