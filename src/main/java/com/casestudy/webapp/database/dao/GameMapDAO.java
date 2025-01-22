package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.GameMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GameMapDAO extends JpaRepository<GameMap, Long> {
    Optional<GameMap> findByPlayerId(Long playerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM GameMap gm WHERE gm.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);
}