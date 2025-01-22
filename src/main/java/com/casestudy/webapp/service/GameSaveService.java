package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.GameSave;
import com.casestudy.webapp.database.entity.Player;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GameSaveService {
    Optional<GameSave> findByPlayerId(Long playerId);

    boolean saveExistsForPlayer(Long playerId);

    void createNewGame(Player player);

    GameSave getSaveForPlayer(Long playerId);

    @Transactional
    void deleteAllPlayerData(Long playerId);

    GameSave getGameSaveByPlayer(Long playerId);
}
