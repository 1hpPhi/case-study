package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Loot;
import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LootDAO extends JpaRepository<Loot, Integer> {

    List<Loot> findByMap(Map map);

    List<Loot> findByMapAndPlayerIsNull(Map map);

    @Modifying
    @Query("UPDATE Loot l SET l.player = :player WHERE l.id = :lootId")
    void takeLoot(Player player, int lootId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Loot l WHERE l.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);
}