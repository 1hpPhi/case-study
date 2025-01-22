package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SkillDAO extends JpaRepository<Skill, Integer> {
    List<Skill> findByPlayerId(Long playerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Skill sk WHERE sk.player.id = :playerId")
    void deleteByPlayerId(@Param("playerId") Long playerId);
}
