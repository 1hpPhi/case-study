package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StatDAO extends JpaRepository<Stat, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Stat st WHERE st.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);


}
