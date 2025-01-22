package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.StoreItem;

import java.util.List;

public interface StoreService {
    List<StoreItem> getAllItems();

    StoreItem addItemToStore(StoreItem item);

    void buyItem(Long itemId, Long playerId);

}
