package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.FoodDAO;
import com.casestudy.webapp.database.entity.Food;
import com.casestudy.webapp.database.entity.Inventory;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private FoodDAO foodDAO;

    @GetMapping
    public String getInventory(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        List<Inventory> inventoryItems = inventoryService.getItemsByPlayerId(player.getId());
        model.addAttribute("inventory", inventoryItems);
        return "game/inventory";
    }

    @PostMapping("/add")
    public String addItemToInventory(@RequestParam Long foodId, @RequestParam int quantity, HttpSession session) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        Food food = foodDAO.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Food item not found"));

        inventoryService.addItemToInventory(player, food, quantity);
        return "redirect:/inventory";
    }

    @PostMapping("/remove")
    public String removeItemFromInventory(@RequestParam int inventoryId, HttpSession session) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        inventoryService.removeItemFromInventory(player, inventoryId);
        return "redirect:/inventory";
    }

    @PostMapping("/update")
    public String updateItemQuantity(@RequestParam int inventoryId, @RequestParam int quantity, HttpSession session) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        inventoryService.updateItemQuantity(inventoryId, quantity);
        return "redirect:/inventory";
    }

    @PostMapping("/equip")
    public String equipItem(@RequestParam int inventoryId, @RequestParam boolean equip, HttpSession session) {
        Player player = (Player) session.getAttribute("player");

        if (player == null) {
            return "redirect:/login/login";
        }

        inventoryService.equipItem(player, inventoryId, equip);
        return "redirect:/inventory";
    }
}
