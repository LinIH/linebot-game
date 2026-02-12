package com.example.rpgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ListEvent")
public class ListEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "description_template", nullable = false)
    private String descriptionTemplate;

    @Column(name = "base_probability", nullable = false)
    private Double baseProbability;

    // Getters and Setters
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescriptionTemplate() {
        return descriptionTemplate;
    }

    public void setDescriptionTemplate(String descriptionTemplate) {
        this.descriptionTemplate = descriptionTemplate;
    }

    public Double getBaseProbability() {
        return baseProbability;
    }

    public void setBaseProbability(Double baseProbability) {
        this.baseProbability = baseProbability;
    }
}
