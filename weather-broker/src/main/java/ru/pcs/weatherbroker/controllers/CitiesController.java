package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.services.CitiesService;

import java.util.Map;

@Controller
@RequestMapping("/administrator/cities")
@RequiredArgsConstructor
public class CitiesController {

    private final CitiesService citiesService;

    @GetMapping()
    public String getAllCities(Model model) {
        Map<City, Integer> cities = citiesService.getAllCitiesWithCountUsers();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/filtred")
    public String getAllCitiesByTemperature(Model model,
                                            @RequestParam("side") String side,
                                            @RequestParam("temperature") Integer temperature) {
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