package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CitiesService {
    public void addCity(CityForm form);
    List<City> getAllCities();
    void deleteUser(City city);
    public Map<String, String> parseJson(String text);

    Optional<City> getCity(Integer cityId);

    void updateCity(Integer cityId);
}
