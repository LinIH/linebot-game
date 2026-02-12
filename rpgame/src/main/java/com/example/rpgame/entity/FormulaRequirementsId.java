package com.example.rpgame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FormulaRequirementsId implements Serializable {

    @Column(name = "formula_id")
    private Integer formulaId;

    @Column(name = "required_item_id")
    private Integer requiredItemId;

    // Constructors
    public FormulaRequirementsId() {
    }

    public FormulaRequirementsId(Integer formulaId, Integer requiredItemId) {
        this.formulaId = formulaId;
        this.requiredItemId = requiredItemId;
    }

    // Getters and Setters
    public Integer getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Integer formulaId) {
        this.formulaId = formulaId;
    }

    public Integer getRequiredItemId() {
        return requiredItemId;
    }

    public void setRequiredItemId(Integer requiredItemId) {
        this.requiredItemId = requiredItemId;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormulaRequirementsId that = (FormulaRequirementsId) o;
        return Objects.equals(formulaId, that.formulaId) &&
               Objects.equals(requiredItemId, that.requiredItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formulaId, requiredItemId);
    }
}
