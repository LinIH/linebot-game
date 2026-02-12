package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListFormula")
public class ListFormula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formula_id")
    private Integer formulaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_item_id", nullable = false)
    private ListItem outputItem;

    @Column(name = "output_quantity", nullable = false)
    private int outputQuantity;

    @Column(name = "stamina_cost", nullable = false)
    private int staminaCost;

    // Getters and Setters
    public Integer getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Integer formulaId) {
        this.formulaId = formulaId;
    }

    public ListItem getOutputItem() {
        return outputItem;
    }

    public void setOutputItem(ListItem outputItem) {
        this.outputItem = outputItem;
    }

    public int getOutputQuantity() {
        return outputQuantity;
    }

    public void setOutputQuantity(int outputQuantity) {
        this.outputQuantity = outputQuantity;
    }

    public int getStaminaCost() {
        return staminaCost;
    }

    public void setStaminaCost(int staminaCost) {
        this.staminaCost = staminaCost;
    }
}
