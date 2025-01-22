package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.form.SignupFormBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/login/login")
    public ModelAndView loginPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }


    @GetMapping("/login/signup")
    public ModelAndView signupPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/signup");
        return response;
    }

    @PostMapping("/login/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();

        if (!form.isPasswordsMatching()) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match.");
        }

        if (bindingResult.hasErrors()) {
            response.setViewName("login/signup");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            User user = new User();
            user.setEmail(form.getUsername());
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);
            userDao.save(user);
            log.info("User created and saved: {}", form.getUsername());

            authenticatedUserService.changeLoggedInUsername(session, form.getUsername(), form.getPassword());

            response.setViewName("redirect:/login/login");
        }

        return response;
    }
}
