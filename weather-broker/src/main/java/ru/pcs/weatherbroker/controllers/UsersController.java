package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.UserFormForAdmin;
import ru.pcs.weatherbroker.models.*;
import ru.pcs.weatherbroker.services.*;

import java.util.List;

@Controller
@RequestMapping("/administrator/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final CitiesService citiesService;

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = usersService.getAllUsers();
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("users", users);
        model.addAttribute("cities", cities);
        return "users";
    }

    @GetMapping("/filtred")
    public String getFiltredUsers(Model model,
                                  @RequestParam("city-id") Integer cityId) {
        List<User> users = usersService.getUserByCity(cityId);
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("users", users);
        model.addAttribute("cities", cities);
        return "users";
    }

    @GetMapping("/{user-id}/edit")
    public String editUser(Model model, @PathVariable("user-id") Integer userId) {
        List<User> users = usersService.getAllUsers();
        User editUser = usersService.getUser(userId);
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("users", users);
        model.addAttribute("editUser", editUser);
        model.addAttribute("cities", cities);
        return "users";
    }

    @PostMapping("/{user-id}/update")
    public String updateUserForAdmin(UserFormForAdmin userFormForAdmin, @PathVariable("user-id") Integer userId) {
        usersService.updateUserForAdmin(userId, userFormForAdmin);
        return "redirect:/administrator/users";
    }

    @PostMapping("/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Integer userId) {
        usersService.deleteUser(userId);
        return "redirect:/administrator/users";
    }

}
