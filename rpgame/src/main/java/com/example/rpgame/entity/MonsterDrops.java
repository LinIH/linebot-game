package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MonsterDrops")
public class MonsterDrops {

    @EmbeddedId
    private MonsterDropsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("monsterId")
    @JoinColumn(name = "monster_id")
    private ListMonster monster;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private ListItem item;

    @Column(name = "drop_chance", nullable = false)
    private Double dropChance;

    // Getters and Setters
    public MonsterDropsId getId() {
        return id;
    }

    public void setId(MonsterDropsId id) {
        this.id = id;
    }

    public ListMonster getMonster() {
        return monster;
    }

    public void setMonster(ListMonster monster) {
        this.monster = monster;
    }

    public ListItem getItem() {
        return item;
    }

    public void setItem(ListItem item) {
        this.item = item;
    }

    public Double getDropChance() {
        return dropChance;
    }

    public void setDropChance(Double dropChance) {
        this.dropChance = dropChance;
    }
}
