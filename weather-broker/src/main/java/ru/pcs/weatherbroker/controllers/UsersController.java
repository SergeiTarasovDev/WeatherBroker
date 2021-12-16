package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);

        return "users";
    }

    /**
     * Ввод данных юзера, на странице users - вроде не нужен
     */
    /*@PostMapping("/users")
    public String addUser(UserForm form) {

        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(form.getPassword())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();

        usersRepository.save(user);

        return "redirect:/users";
    }*/

}
