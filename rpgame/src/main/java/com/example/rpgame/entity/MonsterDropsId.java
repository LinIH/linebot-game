package com.example.rpgame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MonsterDropsId implements Serializable {

    @Column(name = "monster_id")
    private Integer monsterId;

    @Column(name = "item_id")
    private Integer itemId;

    // Constructors
    public MonsterDropsId() {
    }

    public MonsterDropsId(Integer monsterId, Integer itemId) {
        this.monsterId = monsterId;
        this.itemId = itemId;
    }

    // Getters and Setters
    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonsterDropsId that = (MonsterDropsId) o;
        return Objects.equals(monsterId, that.monsterId) &&
               Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monsterId, itemId);
    }
}
