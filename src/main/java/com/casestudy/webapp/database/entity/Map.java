package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Table(name="maps")
@Getter
@Setter
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "difficulty")
    private String difficulty;


    public Map() {
        this.name = "Default Map Name";
        this.difficulty = String.valueOf(1);
    }

    public Map(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
