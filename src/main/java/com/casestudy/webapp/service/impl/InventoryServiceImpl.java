package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.InventoryDAO;
import com.casestudy.webapp.database.entity.Food;
import com.casestudy.webapp.database.entity.Inventory;
import com.casestudy.webapp.database.entity.Player;
import com.casestudy.webapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    // Retrieve items in the player's inventory
    @Override
    public List<Inventory> getItemsByPlayerId(Long playerId) {
        return inventoryDAO.findByPlayerId(playerId);
    }

    @Override
    public void addItemToInventory(Player player, Food food, int quantity) {
        Inventory inventoryItem = new Inventory();
        inventoryItem.setPlayer(player);
        inventoryItem.setFood(food);
        inventoryItem.setQuantity(quantity);
        inventoryDAO.save(inventoryItem);
    }

    @Override
    public void removeItemFromInventory(Player player, int inventoryId) {
        Inventory inventoryItem = inventoryDAO.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));

        if (inventoryItem.getPlayer().getId() == player.getId()) {
            inventoryDAO.delete(inventoryItem);
        } else {
            throw new IllegalArgumentException("Inventory item does not belong to this player");
        }
    }

    @Override
    public void updateItemQuantity(int inventoryId, int newQuantity) {
        Inventory inventoryItem = inventoryDAO.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));

        inventoryItem.setQuantity(newQuantity);
        inventoryDAO.save(inventoryItem);
    }

    @Override
    public void equipItem(Player player, int inventoryId, boolean equip) {
        Inventory inventoryItem = inventoryDAO.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));

        if (inventoryItem.getPlayer().getId() == player.getId()) {
            inventoryItem.setEquipped(equip);
            inventoryDAO.save(inventoryItem);
        } else {
            throw new IllegalArgumentException("Inventory item does not belong to this player");
        }
    }

    @Override
    public void deleteByPlayerId(Long playerId) {
        // Logic to delete all inventory items for the given player
        inventoryDAO.deleteByPlayerId(playerId);
    }
}
