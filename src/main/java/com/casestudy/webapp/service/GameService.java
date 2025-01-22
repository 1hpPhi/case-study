package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.GameMap;
import com.casestudy.webapp.database.entity.Enemy;
import com.casestudy.webapp.database.entity.Player;

public interface GameService {
    GameMap getMapForPlayer(Long playerId);
    Enemy getEnemyForEncounter(Long playerId);
    Enemy generateRandomEnemy();
    boolean shouldPromptOverwrite(Long playerId);

    void handleFight(Long playerId, Long enemyId, int baseFruitDamage);
    void handleFlee(Long playerId);
    Enemy startBattle(Player player);

}
