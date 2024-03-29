package com.example.cardekkho_springboot.Controller;

import com.example.cardekkho_springboot.Service.UserService;
import com.example.cardekkho_springboot.Modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class UserLRController {

    private UserService userService;
@Autowired
    public UserLRController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "Registration";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam("role") String[] role) {
        user.setRoles(role); // Set the role based on the selected option in the form
        userService.saveUser(user); // Save the user to the database
        return "redirect:/signin"; // Redirect to the login page after successful registration
    }
    @GetMapping(path = "/error")
    public String getErrorMessage(){

        return "error";
    }

}
