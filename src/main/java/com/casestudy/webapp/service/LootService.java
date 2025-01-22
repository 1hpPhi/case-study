package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Loot;
import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;

import java.util.List;

public interface LootService {
    List<Loot> getAvailableLoot(Map map);

    void assignLootToPlayer(Player player, int lootId);

    void deleteByPlayerId(Long playerId);
}
