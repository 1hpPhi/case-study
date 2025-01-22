package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.PlayerDAO;
import com.casestudy.webapp.database.entity.Player;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private PlayerDAO playerDAO;

    @GetMapping
    public String viewProfile(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        model.addAttribute("player", player);
        return "profile/view";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute Player updatedPlayer, HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        player.setName(updatedPlayer.getName());

        playerDAO.save(player);
        session.setAttribute("player", player);
        model.addAttribute("player", player);
        return "redirect:/profile";
    }

    @GetMapping("/stats")
    public String viewStats(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        model.addAttribute("player", player);
        return "profile/stats";
    }

    @PostMapping("/level-up")
    public String levelUp(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        player.setLevel(player.getLevel() + 1);
        playerDAO.save(player);

        session.setAttribute("player", player);
        model.addAttribute("player", player);
        return "redirect:/profile";
    }
}
