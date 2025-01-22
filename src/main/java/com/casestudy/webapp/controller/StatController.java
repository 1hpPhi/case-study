package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.StatDAO;
import com.casestudy.webapp.database.entity.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StatController {

    @Autowired
    private StatDAO statsDAO;

    @GetMapping("/stat")
    public String getStats(Model model) {
        Stat stats = statsDAO.findById(1)
                .orElseThrow(() -> new RuntimeException("Stats not found"));
        model.addAttribute("stat", stats);
        return "game/stat";
    }
}
