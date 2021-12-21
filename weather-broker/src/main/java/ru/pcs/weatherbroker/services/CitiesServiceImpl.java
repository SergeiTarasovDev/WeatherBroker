package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.CitiesRepository;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.*;

@RequiredArgsConstructor
@Component
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private WeatherService weatherService;

    private final CitiesRepository citiesRepository;
    private final UsersRepository usersRepository;

    public void addCity(CityForm form) {
        try {
            String result = WeatherService.getWeather(form.getCityName());
            Map<String, String> weather = weatherService.parseJson(result);

            City city = City.builder()
                    .cityName(form.getCityName())
                    .temperature(Double.parseDouble(weather.get("temperature")))
                    .pressure(Double.parseDouble(weather.get("pressure")))
                    .humidity(Integer.parseInt(weather.get("humidity")))
                    .windSpeed(Double.parseDouble(weather.get("windSpeed")))
                    .windDeg(Integer.parseInt(weather.get("windDeg")))
                    .build();

            citiesRepository.save(city);

        } catch (Exception e) {
            System.out.println("Вы ввели неверный код");
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<City> getAllCities() {
        return citiesRepository.findAll();
    }

    @Override
    public void deleteCity(Integer cityId) {
        citiesRepository.deleteById(cityId);
    }

    @Override
    public City getCity(Integer cityId) {
        return citiesRepository.findCityById(cityId);
    }

    @Override
    public List<User> getUserByCity(Integer cityId) {
        return usersRepository.findAllByCity_Id(cityId);
    }

    @Override
    public List<City> getCitiesByTemperatureGreaterThan(Double temperature) {
        return citiesRepository.findCityByTemperatureGreaterThan(temperature);
    }

    @Override
    public List<City> getCitiesByTemperatureLessThan(Double temperature) {
        return citiesRepository.findCityByTemperatureLessThan(temperature);
    }




}
