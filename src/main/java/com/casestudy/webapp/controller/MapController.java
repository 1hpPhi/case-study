package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.InventoryDAO;
import com.casestudy.webapp.database.dao.LootDAO;
import com.casestudy.webapp.database.dao.MapDAO;
import com.casestudy.webapp.database.dao.PlayerDAO;
import com.casestudy.webapp.database.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/map/{mapId}")
public class MapController {

    @Autowired
    private MapDAO mapDAO;

    @Autowired
    private LootDAO lootDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @GetMapping
    public String showMaps(Model model, HttpSession session) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        List<Map> maps = mapDAO.findAll();
        model.addAttribute("maps", maps);
        model.addAttribute("player", player);
        model.addAttribute("pageTitle", "Maps");
        model.addAttribute("contentPage", "game/mapContent.jsp");
        return "common/layout";
    }


    @GetMapping("/loot")
    public String showLoot(@PathVariable int mapId, HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        Map map = mapDAO.findById(mapId)
                .orElseThrow(() -> new IllegalArgumentException("Map with ID " + mapId + " not found"));

        List<Loot> loot = lootDAO.findByMap(map);
        model.addAttribute("loot", loot);
        model.addAttribute("map", map);
        model.addAttribute("player", player);
        model.addAttribute("pageTitle", "Loot");
        model.addAttribute("contentPage", "game/lootContent.jsp");
        return "common/layout";
    }

    @PostMapping("/loot/{lootId}/take")
    public String takeLoot(@PathVariable int mapId, @PathVariable int lootId, HttpSession session) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        Loot loot = lootDAO.findById(lootId)
                .orElseThrow(() -> new IllegalArgumentException("Loot with ID " + lootId + " not found for Map ID " + mapId));

        if (loot.getQuantity() <= 0) {
            throw new IllegalArgumentException("Loot quantity is insufficient for loot ID " + lootId);
        }

        Food food = loot.getFood();
        Inventory existingInventory = inventoryDAO.findByPlayerAndFood(player, food);

        if (existingInventory != null) {
            existingInventory.setQuantity(existingInventory.getQuantity() + 1);
            inventoryDAO.save(existingInventory);
        } else {

            Inventory newInventory = new Inventory();
            newInventory.setPlayer(player);
            newInventory.setFood(food);
            newInventory.setQuantity(1);
            newInventory.setEquipped(false);
            inventoryDAO.save(newInventory);
        }

        loot.setQuantity(loot.getQuantity() - 1);
        lootDAO.save(loot);

        return "redirect:/map/" + mapId + "/loot";
    }
}
