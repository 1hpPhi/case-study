package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Food;
import com.casestudy.webapp.database.entity.Inventory;
import com.casestudy.webapp.database.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByPlayerId(Long playerId);
    Optional<Inventory> findById(Long id);
    Inventory findByPlayerAndFood(Player player, Food food);

    @Transactional
    @Modifying
    @Query("DELETE FROM Inventory i WHERE i.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);
}
