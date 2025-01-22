package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MapDAO extends JpaRepository<Map, Integer> {
    Optional<Map> findByPlayerId(Long playerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Map m WHERE m.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);

}
