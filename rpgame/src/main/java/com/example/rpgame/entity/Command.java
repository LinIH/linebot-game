package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "command")
    String command;
    @Column(name = "subcmd1")
    String subcmd1;
    @Column(name = "method")
    String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSubcmd1() {
        return subcmd1;
    }

    public void setSubcmd1(String subcmd1) {
        this.subcmd1 = subcmd1;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
