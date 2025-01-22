package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Table(name = "inventories")
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "equipped")
    private boolean equipped;

    public Inventory() {}

    public Inventory(Player player, Food food, int quantity, boolean equipped) {
        this.player = player;
        this.food = food;
        this.quantity = quantity;
        this.equipped = equipped;
    }

    public Inventory(Player player, String itemName, int quantity, int damage, String effect) {
        this.player = player;
        this.food = new Food(itemName, "type-placeholder", damage, 0, effect);
        this.quantity = quantity;
        this.equipped = false;
        }

    public Inventory(Player player, Food food, int quantity) {
        this.player = player;
        this.food = food;
        this.quantity = quantity;
    }
}
