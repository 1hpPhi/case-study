package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Enemy;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Skill;

import java.util.List;

public interface EnemyService {
    Enemy findEnemyByLevel(int level);

    int calculateDamage(Player player, Enemy enemy, int baseFruitDamage);

    void save(Enemy enemy);

    Enemy getEnemyById(Long enemyId);

    void deleteByPlayerId(Long playerId);
}
