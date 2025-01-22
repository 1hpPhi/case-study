package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.SkillDAO;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.database.entity.Skill;
import com.casestudy.webapp.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public List<Skill> getSkillsByPlayer(Player player) {
        return skillDAO.findByPlayerId(player.getId());
    }

    @Override
    public void deleteByPlayerId(Long playerId) {
        skillDAO.deleteByPlayerId(playerId);
    }
}