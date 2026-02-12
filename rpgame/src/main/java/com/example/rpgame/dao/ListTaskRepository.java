package com.example.rpgame.dao;

import com.example.rpgame.entity.ListTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListTaskRepository extends JpaRepository<ListTask, Integer> {
}
