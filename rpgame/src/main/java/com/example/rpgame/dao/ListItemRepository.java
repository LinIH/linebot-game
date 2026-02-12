package com.example.rpgame.dao;

import com.example.rpgame.entity.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListItemRepository extends JpaRepository<ListItem, Integer> {
}
