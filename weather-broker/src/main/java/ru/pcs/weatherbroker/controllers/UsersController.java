package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String getAllUsers(Model model,
                              @AuthenticationPrincipal(expression = "id") Integer authId) {
        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);

        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);

        return "users";
    }

    @GetMapping("/filtred")
    public String getFiltredUsers(Model model,
                                  @RequestParam("city-id") Integer cityId,
                                  @AuthenticationPrincipal(expression = "id") Integer authId) {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        List<User> users = usersService.getUserByCity(cityId);
        model.addAttribute("users", users);

        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);

        return "users";
    }

    @GetMapping("/{user-id}/edit")
    public String editUser(Model model,
                           @PathVariable("user-id") Integer userId,
                           @AuthenticationPrincipal(expression = "id") Integer authId) {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);

        User editUser = usersService.getUser(userId);
        model.addAttribute("editUser", editUser);

        List<City> cities = citiesService.getAllCities();
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
