package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="foods")
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "damage")
    private int damage;

    @Column(name = "speed")
    private int speed;

    @Column(name = "effect")
    private String effect;

    public Food(String name, String type, int damage, int speed, String effect) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.effect = effect;
    }

    public Food() {

    }
}
