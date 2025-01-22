package com.casestudy.webapp.security;

import com.casestudy.webapp.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalAttributes {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @ModelAttribute("user")
    public User addUserToModel() {
        return authenticatedUserService.loadCurrentUser();
    }
}
