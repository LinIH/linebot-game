package com.example.rpgame.dao;

import com.example.rpgame.entity.PlayersBackpack;
import com.example.rpgame.entity.PlayersBackpackId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersBackpackRepository extends JpaRepository<PlayersBackpack, PlayersBackpackId> {
}
