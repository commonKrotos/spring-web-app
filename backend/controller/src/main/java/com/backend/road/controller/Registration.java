package com.backend.road.controller;

import com.backend.road.model.User;
import com.backend.road.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Registration {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm")  User userForm,  Model model) {



        if (userService.saveUser(userForm)){
            //model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "redirect:/login";
        }

        return "redirect:/registrationError";
    }
}
