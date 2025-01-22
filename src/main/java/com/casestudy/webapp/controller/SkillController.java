package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.SkillDAO;
import com.casestudy.webapp.database.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SkillController {
    @Autowired
    private SkillDAO skillDAO;

    @GetMapping("/skill")
    public String getSkills(Model model) {
        List<Skill> skill = skillDAO.findAll();
        model.addAttribute("skill", skill);
        return "game/skill";
    }
}
