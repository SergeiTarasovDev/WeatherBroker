package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.services.CitiesService;
import ru.pcs.weatherbroker.services.UsersService;

import java.util.Map;

@Controller
@RequestMapping("/administrator/cities")
@RequiredArgsConstructor
public class CitiesController {

    private final CitiesService citiesService;
    private final UsersService usersService;

    @GetMapping()
    public String getAllCities(Model model,
                               @AuthenticationPrincipal(expression = "id") Integer authId) {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        Map<City, Integer> cities = citiesService.getAllCitiesWithCountUsers();
        model.addAttribute("cities", cities);

        return "cities";
    }

    @GetMapping("/filtred")
    public String getAllCitiesByTemperature(Model model,
                                            @RequestParam("side") String side,
                                            @RequestParam("temperature") String temperature,
                                            @AuthenticationPrincipal(expression = "id") Integer authId) {

        User user = usersService.getUser(authId);
        model.addAttribute("user", user);

        Map<City, Integer> cities = citiesService.getAllCitiesByTemperature(side, temperature);
        model.addAttribute("cities", cities);

        return "cities";
    }

    @PostMapping()
    public String addCity(CityForm form) {
        citiesService.addCity(form);

        return "redirect:/administrator/cities";
    }

    @PostMapping("/{city-id}/delete")
    public String deleteCity(@PathVariable("city-id") Integer cityId) {
        citiesService.deleteCity(cityId);

        return "redirect:/administrator/cities";
    }

}