package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Table(name="skills")
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String effect;

    @Column(name = "buff_percentage")
    private Double buffPercentage;

    @Column(name = "stamina_cost", nullable = false)
    private Integer staminaCost;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
