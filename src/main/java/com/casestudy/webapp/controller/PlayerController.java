package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.*;
import com.casestudy.webapp.database.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Autowired
    private FoodDAO foodDAO;

    @GetMapping("/inventory")
    public String viewInventory(Model model) {
        Player player = (Player) model.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        List<Inventory> inventory = inventoryDAO.findByPlayerId((long) player.getId());
        model.addAttribute("inventory", inventory);
        model.addAttribute("player", player);

        return "game/inventory";
    }



    @PostMapping("/inventory/add")
    public String addFoodToInventory(@RequestParam int foodId, @RequestParam int quantity, Model model) {
        Player player = (Player) model.getAttribute("player");
        if (player == null) {
            return "redirect:/login/login";
        }

        Food food = foodDAO.findById((long) foodId).orElseThrow(() -> new RuntimeException("Food not found"));
        Inventory inventory = new Inventory();
        inventory.setPlayer(player);
        inventory.setFood(food);
        inventory.setQuantity(quantity);
        inventory.setEquipped(false);
        inventoryDAO.save(inventory);

        return "redirect:/player/inventory";
    }
}
