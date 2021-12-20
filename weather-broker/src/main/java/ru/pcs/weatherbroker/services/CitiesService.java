package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;

import java.util.List;
import java.util.Map;

public interface CitiesService {
    void addCity(CityForm form);
    List<City> getAllCities();
    void deleteUser(City city);

    City getCity(Integer cityId);

    List<User> getUserByCity(Integer cityId);

    List<City> getCitiesByTemperatureGreaterThan(Double temperature);
    List<City> getCitiesByTemperatureLessThan(Double temperature);
}
