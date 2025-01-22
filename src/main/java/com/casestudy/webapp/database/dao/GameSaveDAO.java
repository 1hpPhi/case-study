package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.GameSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GameSaveDAO extends JpaRepository<GameSave, Long> {
    Optional<GameSave> findByPlayerId(Long playerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM GameSave gs WHERE gs.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);

}
