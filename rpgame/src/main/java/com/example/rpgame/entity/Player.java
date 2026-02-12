package com.example.rpgame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Players")
public class Player {
    @Id
    @Column(name = "player_id")
    private String playerId;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(name = "hp", nullable = false)
    private int hp;

    @Column(name = "max_hp", nullable = false)
    private int maxHp;

    @Column(name = "stamina", nullable = false)
    private int stamina;

    @Column(name = "max_stamina", nullable = false)
    private int maxStamina;

    @Column(name = "atk", nullable = false)
    private int atk;

    @Column(name = "def", nullable = false)
    private int def;

    @Column(name = "gold", nullable = false)
    private int gold;

    @Column(name = "last_stamina_update", nullable = false)
    private String lastStaminaUpdate; // Using String for ISO 8601 date

    @Column(name = "weapon_id")
    private Integer weaponId;

    @Column(name = "head_id")
    private Integer headId;

    @Column(name = "body_id")
    private Integer bodyId;

    @Column(name = "legs_id")
    private Integer legsId;

    @Column(name = "accessory_id")
    private Integer accessoryId;

    @Column(name = "daily_task_id")
    private Integer dailyTaskId;

    @Column(name = "daily_task_progress")
    private Integer dailyTaskProgress;

    @Column(name = "daily_task_completed")
    private Boolean dailyTaskCompleted;

    // Getters and Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getLastStaminaUpdate() {
        return lastStaminaUpdate;
    }

    public void setLastStaminaUpdate(String lastStaminaUpdate) {
        this.lastStaminaUpdate = lastStaminaUpdate;
    }

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weaponId) {
        this.weaponId = weaponId;
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getLegsId() {
        return legsId;
    }

    public void setLegsId(Integer legsId) {
        this.legsId = legsId;
    }

    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getDailyTaskId() {
        return dailyTaskId;
    }

    public void setDailyTaskId(Integer dailyTaskId) {
        this.dailyTaskId = dailyTaskId;
    }

    public Integer getDailyTaskProgress() {
        return dailyTaskProgress;
    }

    public void setDailyTaskProgress(Integer dailyTaskProgress) {
        this.dailyTaskProgress = dailyTaskProgress;
    }

    public Boolean getDailyTaskCompleted() {
        return dailyTaskCompleted;
    }

    public void setDailyTaskCompleted(Boolean dailyTaskCompleted) {
        this.dailyTaskCompleted = dailyTaskCompleted;
    }
}