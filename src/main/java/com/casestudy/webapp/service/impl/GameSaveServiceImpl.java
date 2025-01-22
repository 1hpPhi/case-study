package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.*;
import com.casestudy.webapp.database.entity.GameSave;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.GameSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GameSaveServiceImpl implements GameSaveService {

    @Autowired
    private GameSaveDAO gameSaveDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Autowired
    private LootDAO lootDAO;

    @Autowired
    private MapDAO mapDAO;

    @Autowired
    private StatDAO statDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public Optional<GameSave> findByPlayerId(Long playerId) {
        return gameSaveDAO.findByPlayerId(playerId);
    }

    @Override
    public boolean saveExistsForPlayer(Long playerId) {
        return gameSaveDAO.findByPlayerId(playerId).isPresent();
    }

    @Override
    public void createNewGame(Player player) {
        if (player == null || player.getId() == null) {
            throw new IllegalArgumentException("Player must exist and have a valid ID");
        }
        GameSave newGame = new GameSave();
        newGame.setPlayer(player);
        newGame.setCurrentPosition("Start");
        newGame.setCurrentHealth(100);
        newGame.setCurrentStamina(50);
        newGame.setCurrentLevel(1);
        gameSaveDAO.save(newGame);
    }


    @Override
    public GameSave getSaveForPlayer(Long playerId) {
        return gameSaveDAO.findByPlayerId(playerId)
                .orElseThrow(() -> new RuntimeException("No save file exists for this player."));
    }

    @Transactional
    @Override
    public void deleteAllPlayerData(Long playerId) {
        if (playerId == null) {
            throw new IllegalArgumentException("Player ID cannot be null.");
        }


        inventoryDAO.deleteByPlayerId(playerId);
        lootDAO.deleteByPlayerId(playerId);
        mapDAO.deleteByPlayerId(playerId);
        statDAO.deleteByPlayerId(playerId);
        skillDAO.deleteByPlayerId(playerId);
        gameSaveDAO.deleteByPlayerId(playerId);
    }


    @Override
    public GameSave getGameSaveByPlayer(Long playerId) {
        return gameSaveDAO.findByPlayerId(playerId).orElse(null);
    }

}