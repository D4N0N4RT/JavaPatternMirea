package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users")
    public String addUser(Model model, String firstName, String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        service.saveUser(user);
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "redirect:/users";
    }
}
