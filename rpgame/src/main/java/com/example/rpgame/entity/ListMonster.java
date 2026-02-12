package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListMonster")
public class ListMonster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monster_id")
    private Integer monsterId;

    @Column(name = "monster_name", nullable = false, unique = true)
    private String monsterName;

    @Column(name = "hp", nullable = false)
    private int hp;

    @Column(name = "atk", nullable = false)
    private int atk;

    @Column(name = "def", nullable = false)
    private int def;

    @Column(name = "gold_drop", nullable = false)
    private int goldDrop;

    // Getters and Setters
    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }
}
