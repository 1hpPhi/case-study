package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.StoreDAO;
import com.casestudy.webapp.database.entity.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StoreController {
    @Autowired
    private StoreDAO storeDAO;

    @GetMapping("/store")
    public String getStore(Model model) {
        List<StoreItem> storeItems = storeDAO.findAll();
        model.addAttribute("storeItems", storeItems);
        return "game/store";
    }
}
