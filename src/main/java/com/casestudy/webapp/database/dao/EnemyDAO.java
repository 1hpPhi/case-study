package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EnemyDAO extends JpaRepository<Enemy, Long> {
    Optional<Enemy> findByPlayerId(Long playerId);
    Optional<Enemy> findFirstByLevel(int level);

    @Query(value = "SELECT e FROM Enemy e ORDER BY FUNCTION('RAND')")
    Optional<Enemy> findRandomEnemy();

    @Transactional
    @Modifying
    @Query("DELETE FROM Enemy e WHERE e.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);
}
