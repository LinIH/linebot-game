package com.example.rpgame.dao;

import com.example.rpgame.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Integer> {
    Command findByCommandAndSubcmd1(String part, String part1);
}
