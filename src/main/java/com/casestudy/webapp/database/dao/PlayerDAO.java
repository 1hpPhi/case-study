package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerDAO extends JpaRepository<Player, Long> {
    List<Player> findByUserId(Long userId);
    boolean existsById(Long id);
    void deleteById(Long id);
}
