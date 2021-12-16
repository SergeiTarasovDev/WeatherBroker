package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;
import ru.pcs.weatherbroker.services.ConnectionWeatherApi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

        try {
            ConnectionWeatherApi connectionWeatherApi = new ConnectionWeatherApi();
            Map<String, String> result = connectionWeatherApi.getWeather(form.getCityName());

            City city = City.builder()
                    .cityName(form.getCityName())
                    .temperature(Double.parseDouble(result.get("temperature")))
                    .pressure(Double.parseDouble(result.get("pressure")))
                    .humidity(Integer.parseInt(result.get("humidity")))
                    .windSpeed(Double.parseDouble(result.get("windSpeed")))
                    .windDeg(Integer.parseInt(result.get("windDeg")))
                    .build();

            citiesRepository.save(city);

        } catch (Exception e) {
            System.out.println("Вы ввели неверный код");
            throw new IllegalArgumentException(e);
        }

        return "redirect:/cities";
    }

}