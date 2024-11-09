package com.blackdots.busbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blackdots.busbooking.model.User;
import com.blackdots.busbooking.repository.SignupRepository;
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

    

    @PostMapping("/register")
        public String registerForm(@ModelAttribute User form) {

            String name = form.getName();
            String username = form.getUsername();
            String password = form.getPassword();
            String gender = form.getGender();
            String email = form.getEmail();
            String mobile = form.getMobile();

            SignupRepository repository = new SignupRepository();
            //  boolean sucess =  repository.signup(name, username, password, gender, mobile, email);
            boolean sucess = repository.signUpwithObject(form);
            if(sucess){
                System.out.println("Register Sucessful");
                return "login";

            }
            else{
                System.out.println("Register unSucessful");

                return "signup";
            }
        

        
    }

}
