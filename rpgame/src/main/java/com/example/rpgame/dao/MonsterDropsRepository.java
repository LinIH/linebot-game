package com.example.rpgame.dao;

import com.example.rpgame.entity.MonsterDrops;
import com.example.rpgame.entity.MonsterDropsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterDropsRepository extends JpaRepository<MonsterDrops, MonsterDropsId> {
}
