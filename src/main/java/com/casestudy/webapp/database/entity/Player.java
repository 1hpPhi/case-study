package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Slf4j
@Table(name = "players")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private GameSave gameSave;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stat> stats;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enemy> enemies;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loot> lootItems;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameMap> gameMaps = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "health", nullable = false, columnDefinition = "int default 100")
    private int health;

    @Column(name = "stamina", nullable = false, columnDefinition = "int default 50")
    private int stamina;

    @Column(name = "level", nullable = false, columnDefinition = "int default 1")
    private int level;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "player_class")
    private String playerClass;

    @Column(name = "difficulty")
    private String difficulty;

    public Player() {

    }

    public Player(String name) {
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void levelUp() {
        this.level++;
        this.health += 10;
        this.stamina += 5;
    }


    public Player(Long userId, String name) {
        this.user.setId(userId);
        this.name = name;
        this.health = 100;
        this.stamina = 50;
        this.level = 1;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void adjustDifficulty(String difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case "hard":
                this.health -= 20;
            case "easy":
                this.health += 20;
                break;
        }
    }
}
