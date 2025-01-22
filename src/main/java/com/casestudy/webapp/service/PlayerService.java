package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(Long playerId);
    List<Player> findByUserId(Long id);
    Player save(Player player);
    void deletePlayerById(Long playerId);
    Player getCurrentPlayer(Long playerId);
    boolean existsById(Long playerId);
}
