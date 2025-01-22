package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "game_map")
@Getter
@Setter
public class GameMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "map_name")
    private String mapName;

    @Column(name = "map_description")
    private String mapDescription;

    @Column(name = "current_location")
    private String currentLocation;

}
