package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.FoodDAO;
import com.casestudy.webapp.database.dao.InventoryDAO;
import com.casestudy.webapp.database.entity.Food;
import com.casestudy.webapp.database.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodDAO foodDAO;

    @Autowired
    private InventoryDAO inventoryDAO;



    @GetMapping("/api")
    public @ResponseBody List<Food> getAllFood() {
        return foodDAO.findAll();
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        List<Food> foods = foodDAO.findAll();
        model.addAttribute("foods", foods);
        return "game/inventory";
    }

    @PostMapping("/throw")
    public String throwFood(@RequestParam("foodId") int foodId, @RequestParam("quantity") int quantity, Model model) {
        Food food = foodDAO.findById((long) foodId).orElseThrow(() -> new RuntimeException("Food not found"));

        int totalDamage = food.getDamage() * quantity;

        model.addAttribute("message", "You threw " + food.getName() + " and dealt " + totalDamage + " damage");

        return "food/throwResult";
    }



    @PostMapping("/add")
    public String addToInventory(@RequestParam("foodId") int foodId, @RequestParam("quantity") int quantity) {
        Food food = foodDAO.findById((long) foodId).orElseThrow(() -> new RuntimeException("Food not found"));


        Inventory inventory = new Inventory();
        inventory.setFood(food);
        inventory.setQuantity(quantity);
        inventoryDAO.save(inventory);

        return "redirect:/inventory";
    }

}
