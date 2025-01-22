package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="game_save")
@Getter
@Setter
public class GameSave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "current_position", nullable = false)
    private String currentPosition;

    @Column(name = "current_health", nullable = false)
    private Integer currentHealth;

    @Column(name = "current_stamina", nullable = false)
    private Integer currentStamina;

    @Column(name = "current_level", nullable = false)
    private Integer currentLevel;
}
