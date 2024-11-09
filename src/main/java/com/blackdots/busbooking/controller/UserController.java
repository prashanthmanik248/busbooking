package com.blackdots.busbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blackdots.busbooking.model.User;

import com.blackdots.busbooking.service.UserService;


@Controller
public class UserController {

@Autowired
UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("form", new User());
        return "signup";
    }


    @PostMapping("/register")
        public String registerForm1(@ModelAttribute User form){
            userService.registerUser(form);
            return "login";

        }

    



}
