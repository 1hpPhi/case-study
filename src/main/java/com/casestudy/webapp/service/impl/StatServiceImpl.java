package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Stat;
import com.casestudy.webapp.database.dao.StatDAO;
import com.casestudy.webapp.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatDAO statDAO;

    @Override
    public Stat initializeStartingStats(Player player) {
        Stat startingStats = new Stat();
        startingStats.setPlayer(player);
        startingStats.setHealth(100);
        startingStats.setStamina(50);
        startingStats.setLevel(1);
        statDAO.save(startingStats);
        return startingStats;
    }

    @Override
    public void deleteByPlayerId(Long playerId) {
        statDAO.deleteByPlayerId(playerId);
    }
}
