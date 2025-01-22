package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Food;
import com.casestudy.webapp.database.entity.Inventory;
import com.casestudy.webapp.database.entity.Player;

import java.util.List;

public interface InventoryService {
    List<Inventory> getItemsByPlayerId(Long playerId);

    void addItemToInventory(Player player, Food food, int quantity);

    void removeItemFromInventory(Player player, int inventoryId);

    void updateItemQuantity(int inventoryId, int newQuantity);

    void equipItem(Player player, int inventoryId, boolean equip);

    void deleteByPlayerId(Long playerId);
}
