package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.forms.UserFormForAdmin;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.services.CitiesService;
import ru.pcs.weatherbroker.services.UsersService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CitiesService citiesService;

    @GetMapping("/administrator/users")
    public String getAllUsers(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/administrator/users/{user-id}/edit")
    public String editUser(Model model, @PathVariable("user-id") Integer userId) {
        List<User> users = usersService.getAllUsers();
        User editUser = usersService.getUser(userId);
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("users", users);
        model.addAttribute("editUser", editUser);
        model.addAttribute("cities", cities);
        return "users";
    }

    @PostMapping("/administrator/users/{user-id}/update")
    public String updateUserForAdmin(UserFormForAdmin userFormForAdmin, @PathVariable("user-id") Integer userId) {
        usersService.updateUserForAdmin(userId, userFormForAdmin);
        return "redirect:/administrator/users";
    }

    @PostMapping("/administrator/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Integer userId) {
        usersService.deleteUser(userId);
        return "redirect:/administrator/users";
    }

}
