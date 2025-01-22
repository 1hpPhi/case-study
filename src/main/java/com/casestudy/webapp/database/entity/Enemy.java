package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enemies")
@Getter
@Setter
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "health", nullable = false)
    private int health;

    @Column(name = "stamina", nullable = false)
    private int stamina;

    @Column(name = "fruit_resistance", nullable = false)
    private double fruitResistance;

    @Column(name = "attack_damage")
    private int attackDamage;
}
