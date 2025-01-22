package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class NavController {
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @ModelAttribute("user")
    public User loggedInUser() {
        return authenticatedUserService.loadCurrentUser();
    }
}
