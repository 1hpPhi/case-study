package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getSkillsByPlayer(Player player);
    void deleteByPlayerId(Long playerId);
}
