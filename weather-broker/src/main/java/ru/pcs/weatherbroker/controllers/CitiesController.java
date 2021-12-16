package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;

import java.util.List;

@Controller
public class CitiesController {

    @Autowired
    private CitiesRepository citiesRepository;

    @GetMapping("/cities")
    public String getAllCities(Model model) {
        List<City> cities = citiesRepository.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @PostMapping("/cities")
    public String addCity(CityForm form) {

        City city = City.builder()
                .cityName(form.getCityName())
                .currentTemperature(form.getCurrentTemperature())
                .build();

        citiesRepository.save(city);

        return "redirect:/cities";
    }

}