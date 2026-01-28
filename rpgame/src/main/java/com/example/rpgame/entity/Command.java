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

    public String getMethod() {
        return method;
    }
}
