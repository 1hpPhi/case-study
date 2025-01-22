package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.LootDAO;
import com.casestudy.webapp.database.entity.Loot;
import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.LootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LootServiceImpl implements LootService {

    @Autowired
    private LootDAO lootDAO;

    @Override
    public List<Loot> getAvailableLoot(Map map) {
        return lootDAO.findByMapAndPlayerIsNull(map);
    }

    @Transactional
    @Override
    public void assignLootToPlayer(Player player, int lootId) {
        lootDAO.takeLoot(player, lootId);
    }

    @Override
    public void deleteByPlayerId(Long playerId) {
        lootDAO.deleteByPlayerId(playerId);
    }
}