package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.PlayerDAO;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;


    @Override
    public Player getPlayerById(Long playerId) {
        return playerDAO.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));
    }

    @Override
    public List<Player> findByUserId(Long userId) {
        return playerDAO.findByUserId(userId);
    }

    @Override
    public Player save(Player player) {
        return playerDAO.save(player);
    }

    @Override
    public void deletePlayerById(Long playerId) {
        playerDAO.deleteById(playerId);
    }

    @Override
    public Player getCurrentPlayer(Long playerId) {
        return playerDAO.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("No player found with ID: " + playerId));
    }

    @Override
    public boolean existsById(Long playerId) {
        return playerDAO.existsById(playerId);
    }
}
