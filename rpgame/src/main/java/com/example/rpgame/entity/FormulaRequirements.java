package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FormulaRequirements")
public class FormulaRequirements {

    @EmbeddedId
    private FormulaRequirementsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("formulaId")
    @JoinColumn(name = "formula_id")
    private ListFormula formula;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("requiredItemId")
    @JoinColumn(name = "required_item_id")
    private ListItem requiredItem;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Getters and Setters
    public FormulaRequirementsId getId() {
        return id;
    }

    public void setId(FormulaRequirementsId id) {
        this.id = id;
    }

    public ListFormula getFormula() {
        return formula;
    }

    public void setFormula(ListFormula formula) {
        this.formula = formula;
    }

    public ListItem getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(ListItem requiredItem) {
        this.requiredItem = requiredItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
