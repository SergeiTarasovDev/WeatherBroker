package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.services.AccountService;
import ru.pcs.weatherbroker.services.CitiesService;
import ru.pcs.weatherbroker.services.UsersService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CitiesService citiesService;

    @GetMapping("/account")
    public String getUserAccount(Model model,
                                 @AuthenticationPrincipal(expression = "id") Integer authId) throws InterruptedException {
        User user = usersService.getUser(authId);
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("user", user);
        model.addAttribute("cities", cities);

        return accountService.getAuthorizedUserPage(authId);
    }

    @GetMapping(value = "/account", params = "cityId")
    public String getCityPage(Model model,
                              @RequestParam(name = "cityId") Integer cityId,
                              @AuthenticationPrincipal(expression = "id") Integer authId) {
        User user = usersService.getUser(authId);
        List<City> cities = citiesService.getAllCities();
        City city = citiesService.getCity(cityId);

        model.addAttribute("user", user);
        model.addAttribute("cities", cities);
        model.addAttribute("city", city);
        return "account";
    }

    @GetMapping("account/config")
    public String getConfig(Model model,
                            @AuthenticationPrincipal(expression = "id") Integer authId) {
        User user = usersService.getUser(authId);
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("user", user);
        model.addAttribute("cities", cities);
        return "accountConfig";
    }

    @PostMapping("account/{user-id}/update")
    public String update(@PathVariable("user-id") Integer userId, UserForm userForm) {
        usersService.updateUser(userId, userForm);
        return "redirect:/account";
    }

}
