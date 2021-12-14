package ru.pcs.weatherbroker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.models.User;

@Controller
public class UsersController {
    @PostMapping("/users")
    public String addUser(@RequestParam("login") String login,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email) {
        System.out.println(login + " " + password + " " + email);


        /* TODO: Конец 28го видео
        User user = User.builder()
                .login(login)
                .password(password)
                .email(email)
                .build();
        userRepository.save(user);
         */

        return "redirect:/index.html";
    }

}
