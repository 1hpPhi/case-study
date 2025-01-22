package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.MapDAO;
import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {
    private final MapDAO mapDAO;

    @Autowired
    public MapServiceImpl(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public Map getPlayerMap(Player player) {
        Optional<Map> optionalMap = mapDAO.findByPlayerId(player.getId());

        Map map = optionalMap.orElseGet(() -> {
            Map newMap = new Map();
            newMap.setPlayer(player);
            return mapDAO.save(newMap);
        });

        return map;
    }

    @Override
    public Map generateMapForPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        Map newMap = new Map();
        newMap.setName("Generated Map for " + player.getName()); // Set name
        newMap.setDescription("A procedurally generated map for the player's level.");
        newMap.setDifficulty(String.valueOf(player.getLevel() * 2));
        newMap.setPlayer(player);

        return mapDAO.save(newMap);
    }

    @Override
    public Map save(Map map) {
        return mapDAO.save(map);
    }
}
