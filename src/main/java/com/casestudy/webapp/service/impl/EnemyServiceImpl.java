package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.EnemyDAO;
import com.casestudy.webapp.database.entity.Enemy;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Skill;
import com.casestudy.webapp.service.EnemyService;
import com.casestudy.webapp.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnemyServiceImpl implements EnemyService {

    @Autowired
    private EnemyDAO enemyDAO;

    @Autowired
    private SkillService skillService;

    @Override
    public Enemy findEnemyByLevel(int level) {
        return enemyDAO.findFirstByLevel(level)
                .orElseThrow(() -> new RuntimeException("No enemy found for this level."));
    }

    @Override
    public int calculateDamage(Player player, Enemy enemy, int baseFruitDamage) {
        List<Skill> skills = skillService.getSkillsByPlayer(player);
        double totalBuff = skills.stream()
                .filter(Skill::getIsActive)
                .mapToDouble(Skill::getBuffPercentage)
                .sum();

        double modifiedDamage = baseFruitDamage * (1 + totalBuff);
        return (int) (modifiedDamage * (1 - enemy.getFruitResistance()));
    }

    @Override
    public void save(Enemy enemy) {
        enemyDAO.save(enemy);
    }

    @Override
    public Enemy getEnemyById(Long enemyId) {
        return enemyDAO.findById(enemyId)
                .orElseThrow(() -> new RuntimeException("Enemy not found."));
    }

    @Override
    public void deleteByPlayerId(Long playerId) {
        enemyDAO.deleteByPlayerId(playerId);
    }
}