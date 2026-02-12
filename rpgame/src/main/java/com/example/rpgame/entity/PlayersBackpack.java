package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PlayersBackpack")
public class PlayersBackpack {

    @EmbeddedId
    private PlayersBackpackId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private ListItem item;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Getters and Setters
    public PlayersBackpackId getId() {
        return id;
    }

    public void setId(PlayersBackpackId id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ListItem getItem() {
        return item;
    }

    public void setItem(ListItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
