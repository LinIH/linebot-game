package com.example.rpgame.dao;

import com.example.rpgame.entity.FormulaRequirements;
import com.example.rpgame.entity.FormulaRequirementsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaRequirementsRepository extends JpaRepository<FormulaRequirements, FormulaRequirementsId> {
}
