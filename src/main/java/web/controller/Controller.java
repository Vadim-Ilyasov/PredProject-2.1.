package web.controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }

    @GetMapping("/users/{id}/replacement")
    public String replacement(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "replacement";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User updateUser, @PathVariable("id") long id) {
        userService.updateUser(id, updateUser);
        return "redirect:/users";
    }

}