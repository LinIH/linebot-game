package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListItem")
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;

    @Column(name = "item_type", nullable = false)
    private String itemType;

    @Column(name = "description")
    private String description;

    @Column(name = "effect_type")
    private String effectType;

    @Column(name = "effect_value")
    private Integer effectValue;

    @Column(name = "durability")
    private Integer durability;

    @Column(name = "atk_bonus")
    private Integer atkBonus;

    @Column(name = "def_bonus")
    private Integer defBonus;

    // Getters and Setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public Integer getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(Integer effectValue) {
        this.effectValue = effectValue;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    public Integer getAtkBonus() {
        return atkBonus;
    }

    public void setAtkBonus(Integer atkBonus) {
        this.atkBonus = atkBonus;
    }

    public Integer getDefBonus() {
        return defBonus;
    }

    public void setDefBonus(Integer defBonus) {
        this.defBonus = defBonus;
    }
}
