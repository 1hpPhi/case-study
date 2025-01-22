
package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.EnemyDAO;
import com.casestudy.webapp.database.dao.GameMapDAO;
import com.casestudy.webapp.database.dao.PlayerDAO;
import com.casestudy.webapp.database.entity.GameMap;
import com.casestudy.webapp.database.entity.Enemy;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapDAO gameMapDAO;

    @Autowired
    private EnemyDAO enemyDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public GameMap getMapForPlayer(Long playerId) {
        Player player = playerDAO.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found for ID: " + playerId));

        return gameMapDAO.findByPlayerId(playerId)
                .orElseGet(() -> {
                    GameMap newMap = new GameMap();
                    newMap.setPlayer(player);
                    return gameMapDAO.save(newMap);
                });
    }

    @Override
    public Enemy getEnemyForEncounter(Long playerId) {
        return enemyDAO.findByPlayerId(playerId)
                .orElseGet(() -> {

                    Player player = playerDAO.findById(playerId)
                            .orElseThrow(() -> new EntityNotFoundException("Player not found for ID: " + playerId));

                    Enemy newEnemy = new Enemy();
                    newEnemy.setPlayer(player);


                    newEnemy.setName("Default Enemy");

                    return enemyDAO.save(newEnemy);
                });
    }

    @Override
    public boolean shouldPromptOverwrite(Long playerId) {
        return true;
    }

    @Override
    public void handleFight(Long playerId, Long enemyId, int baseFruitDamage) {
        Player player = playerDAO.findById(playerId).orElseThrow(() -> new IllegalArgumentException("Player not found"));
        Enemy enemy = enemyDAO.findById(enemyId).orElseThrow(() -> new IllegalArgumentException("Enemy not found"));

        int totalDamage = baseFruitDamage;


        enemy.setHealth(enemy.getHealth() - totalDamage);
        enemyDAO.save(enemy);

        playerDAO.save(player);
    }

    @Override
    public void handleFlee(Long playerId) {
        Player player = playerDAO.findById(playerId).orElseThrow(() -> new IllegalArgumentException("Player not found"));

        player.setHealth(player.getHealth() - 5);
        playerDAO.save(player);
    }

    @Override
    public Enemy generateRandomEnemy() {
        Optional<Enemy> randomEnemyOpt = enemyDAO.findRandomEnemy();
        if (randomEnemyOpt.isEmpty()) {
            throw new RuntimeException("No enemies available");
        }
        return randomEnemyOpt.get();
    }

    @Override
    public Enemy startBattle(Player player) {
        Enemy randomEnemy = generateRandomEnemy();
        return randomEnemy;
    }
}