package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;

import java.util.List;
import java.util.Map;

public interface CitiesService {
    void addCity(CityForm form);
    List<City> getAllCities();
    void deleteCity(Integer cityId);
    City getCity(Integer cityId);
    Map<City, Integer> getAllCitiesWithCountUsers();
    Map<City, Integer> getAllCitiesByTemperature(String side, Integer temperature);
}
