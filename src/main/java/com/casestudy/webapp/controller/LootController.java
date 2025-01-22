package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.entity.Loot;
import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.LootService;
import com.casestudy.webapp.service.MapService;
import com.casestudy.webapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/loot")
public class LootController {

    private final LootService lootService;
    private final MapService mapService;
    private final PlayerService playerService;

    @Autowired
    public LootController(LootService lootService, MapService mapService, PlayerService playerService) {
        this.lootService = lootService;
        this.mapService = mapService;
        this.playerService = playerService;
    }

    @GetMapping("/{mapId}")
    public String viewLoot(@PathVariable Long mapId, HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        Map map = mapService.getPlayerMap(player);

        List<Loot> lootItems = lootService.getAvailableLoot(map);

        model.addAttribute("mapId", mapId);
        model.addAttribute("loot", lootItems);
        model.addAttribute("playerId", player.getId());
        return "game/loot";
    }

    @GetMapping("/{mapId}/loot/{lootId}/take")
    public String takeLoot(@PathVariable Long mapId, @PathVariable int lootId, HttpSession session) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        lootService.assignLootToPlayer(player, lootId);

        return "redirect:/loot/" + mapId;
    }
}
