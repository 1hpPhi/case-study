package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Stat;

public interface StatService {
    Stat initializeStartingStats(Player player);
    void deleteByPlayerId(Long playerId);
}