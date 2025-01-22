package com.casestudy.webapp.service;

import com.casestudy.webapp.database.entity.Map;
import com.casestudy.webapp.database.entity.Player;

public interface MapService {
    Map getPlayerMap(Player player);
    Map generateMapForPlayer(Player player);
    Map save(Map map);
}
