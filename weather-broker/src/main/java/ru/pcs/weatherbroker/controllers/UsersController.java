package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;
import ru.pcs.weatherbroker.services.UsersService;

import java.security.Principal;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{user-id}/user")
    public String getUserPage(Model model, @PathVariable("user-id") Integer userId) {
        User user = usersService.getUser(userId);
        model.addAttribute("user", user);
        return "user";
    }
}
