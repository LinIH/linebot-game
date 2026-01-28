package com.example.rpgame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @Column(name = "id")
    String id;

    @Column(name = "player_name")
    String playerName;

    @Column(name = "hp")
    int hp;

    @Column(name = "max_hp")
    int maxHp;

    @Column(name = "stamina")
    int stamina;

    @Column(name = "max_stamina")
    int maxStamina;

    @Column(name = "atk")
    int atk;

    @Column(name = "def")
    int def;

    @Column(name = "weapon_id")
    int weaponId;

    @Column(name = "armor_id")
    int armorId;

    @Column(name = "daily_task_id")
    int dailyTaskId;

    @Column(name = "daily_task_status")
    int dailyTaskStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
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

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public int getDailyTaskId() {
        return dailyTaskId;
    }

    public void setDailyTaskId(int dailyTaskId) {
        this.dailyTaskId = dailyTaskId;
    }

    public int getDailyTaskStatus() {
        return dailyTaskStatus;
    }

    public void setDailyTaskStatus(int dailyTaskStatus) {
        this.dailyTaskStatus = dailyTaskStatus;
    }
}
