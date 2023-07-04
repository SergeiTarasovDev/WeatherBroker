package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.models.*;
import ru.pcs.weatherbroker.services.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final UsersService usersService;
    private final CitiesService citiesService;

    @GetMapping("/account")
    public String getUserPage(Model model,
                              @AuthenticationPrincipal(expression = "id") Integer authId) throws InterruptedException {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);

        return accountService.getAuthorizedUserPage(authId);
    }

    @GetMapping(value = "/account", params = "cityId")
    public String getAnotherCityPage(Model model,
                                     @RequestParam(name = "cityId") Integer cityId,
                                     @AuthenticationPrincipal(expression = "id") Integer authId) {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);

        City city = citiesService.getCity(cityId);
        model.addAttribute("city", city);

        return "account";
    }

    @GetMapping("account/config")
    public String getUserConfig(Model model,
                                @AuthenticationPrincipal(expression = "id") Integer authId) {

        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        return "accountConfig";
    }

    @PostMapping("account/{user-id}/update")
    public String updateUserData(@PathVariable("user-id") Integer userId,
                                 UserForm userForm) {

        usersService.updateUser(userId, userForm);

        return "redirect:/account";
    }
}
