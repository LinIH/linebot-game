package com.example.rpgame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayersBackpackId implements Serializable {

    @Column(name = "player_id")
    private String playerId;

    @Column(name = "item_id")
    private Integer itemId;

    // Constructors
    public PlayersBackpackId() {
    }

    public PlayersBackpackId(String playerId, Integer itemId) {
        this.playerId = playerId;
        this.itemId = itemId;
    }

    // Getters and Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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
        PlayersBackpackId that = (PlayersBackpackId) o;
        return Objects.equals(playerId, that.playerId) &&
               Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, itemId);
    }
}
