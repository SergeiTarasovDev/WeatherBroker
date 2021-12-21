package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.services.CitiesService;

import java.util.List;

@Controller
public class CitiesController {

    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("administrator/cities")
    public String getAllCities(Model model) {
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @PostMapping("/administrator/cities")
    public String addCity(CityForm form) {
        citiesService.addCity(form);
        return "redirect:/administrator/cities";
    }

    @PostMapping("/administrator/cities/{city-id}/delete")
    public String deleteCity(@PathVariable("city-id") Integer cityId) {
        citiesService.deleteCity(cityId);
        return "redirect:/administrator/cities";
    }

/*
    @GetMapping("/city")
    public String getCityPage(Model model, @RequestParam(name = "cityId") Integer cityId) {
        List<City> cities = citiesService.getAllCities();
        City city = citiesService.getCity(cityId);
        model.addAttribute("cities", cities);
        model.addAttribute("city", city);
        return "city";
    }

    @GetMapping("/cities/{city-id}/users")
    public String getUsersByCity(Model model, @PathVariable("city-id") Integer cityId) {
        List<User> users = citiesService.getUserByCity(cityId);
        model.addAttribute("users", users);
        return "users_of_city";
    }

    @GetMapping("/cities/{city-id}/weather")
    public String getWeatherByCity(Model model, @PathVariable("city-id") Integer cityId) {
        City city = citiesService.getCity(cityId);
        model.addAttribute("city", city);
        return "city";
    }

    @GetMapping("/cities/{temperature}/temp-great")
    public String getCitiesByTemperatureGreateThan(Model model, @PathVariable("temperature") Double temperature) {
        List<City> cities = citiesService.getCitiesByTemperatureGreaterThan(temperature);
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/cities/{temperature}/temp-less")
    public String getCitiesByTemperatureLessThan(Model model, @PathVariable("temperature") Double temperature) {
        List<City> cities = citiesService.getCitiesByTemperatureLessThan(temperature);
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/cities/")
    public String getCity(Model model, @PathVariable("city-id") Integer cityId) {
        System.out.println(cityId);
        City city = citiesService.getCity(cityId);
        model.addAttribute("city", city);
        return "city";
    }

 */

}