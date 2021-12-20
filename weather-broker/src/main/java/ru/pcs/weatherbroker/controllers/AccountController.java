package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.services.CitiesService;
import ru.pcs.weatherbroker.services.UsersService;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CitiesService citiesService;

    @GetMapping("/account")
    public String getUserAccount(Model model,
                                 @AuthenticationPrincipal(expression = "id") Integer authId) {
        User user = usersService.getUser(authId);
        String userRole = user.getRole().toString();
        List<City> cities = citiesService.getAllCities();

        model.addAttribute("user", user);
        //model.addAttribute("city", user.getCity());
        model.addAttribute("cities", cities);

        if (userRole.equals("ADMIN")) {
            return "redirect:/administrator";
        }
        return "account";
    }

    @GetMapping(value = "/account", params = "cityId")
    public String getCityPage(Model model,
                              @RequestParam(name = "cityId") Integer cityId,
                              @AuthenticationPrincipal(expression = "id") Integer authId) {
        System.out.println("2");
        User user = usersService.getUser(authId);
        List<City> cities = citiesService.getAllCities();
        City city = citiesService.getCity(cityId);

        model.addAttribute("user", user);
        model.addAttribute("cities", cities);
        model.addAttribute("city", city);
        return "account";
    }

    @GetMapping("/administrator")
    public String getAdministrator(Model model,
                                   @AuthenticationPrincipal(expression = "id") Integer authId) {
        User user = usersService.getUser(authId);
        model.addAttribute("user", user);
        return "administrator";
    }

}
