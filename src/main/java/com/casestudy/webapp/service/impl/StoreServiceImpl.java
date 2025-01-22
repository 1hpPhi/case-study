package com.casestudy.webapp.service.impl;

import com.casestudy.webapp.database.dao.StoreDAO;
import com.casestudy.webapp.database.entity.StoreItem;
import com.casestudy.webapp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDAO storeDAO;

    @Override
    public List<StoreItem> getAllItems() {
        return storeDAO.findAll();
    }

    @Override
    public StoreItem addItemToStore(StoreItem item) {
        return storeDAO.save(item);
    }

    @Override
    public void buyItem(Long itemId, Long playerId) {
        StoreItem item = storeDAO.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        // Additional logic for buying the item, like checking if the player has enough money, etc.
    }


}