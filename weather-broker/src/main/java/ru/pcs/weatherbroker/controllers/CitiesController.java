package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.services.CitiesService;

import java.util.List;
import java.util.Optional;

@Controller
public class CitiesController {

    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/cities")
    public String getAllCities(Model model) {
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/cities/{city-id}")
    public String getCityPage(Model model, Integer cityId) {
        Optional<City> city = citiesService.getCity(cityId);
        model.addAttribute("city", city);
        return "city";
    }


    @PostMapping("/cities")
    public String addCity(CityForm form) {
        citiesService.addCity(form);
        return "redirect:/cities";
    }

    @PostMapping("/cities/{city-id}/delete")
    public String deleteCity(@PathVariable("city-id") City city) {
        citiesService.deleteUser(city);
        return "redirect:/cities";
    }

    /*@PostMapping("/cities/{city-id}/update")
    public String updateCity(@PathVariable("city-id") Integer cityId) {
        citiesService.updateCity(cityId);
        return "redirect/cities/{city-id}";
    }*/

}