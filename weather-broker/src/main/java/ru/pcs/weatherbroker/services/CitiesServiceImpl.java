package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.*;

@RequiredArgsConstructor
@Component
public class CitiesServiceImpl implements CitiesService {

    private final WeatherService weatherService;
    private final CitiesRepository citiesRepository;
    private final UsersRepository usersRepository;

    public void addCity(CityForm form) {
        try {
            String result = weatherService.getWeather(form.getCityName());
            if (!result.equals("-1")) {
                Map<String, String> weather = weatherService.parseJson(result);

                City city = City.builder()
                        .cityName(form.getCityName())
                        .temperature(Integer.parseInt(weather.get("temperature")))
                        .pressure(Double.parseDouble(weather.get("pressure")))
                        .humidity(Integer.parseInt(weather.get("humidity")))
                        .windSpeed(Double.parseDouble(weather.get("windSpeed")))
                        .windDeg(Integer.parseInt(weather.get("windDeg")))
                        .icon(weather.get("icon"))
                        .build();

                citiesRepository.save(city);
            }
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

    private Map<City, Integer> getCitiesWithCountUsers(List<City> cities) {
        Map<City, Integer> map = new HashMap<>();

        if (cities != null) {
            for (City city : cities) {
                Integer countUsers = usersRepository.countUsersByCity(city);
                map.put(city, countUsers);
            }
        }
        return map;
    }

    @Override
    public Map<City, Integer> getAllCitiesWithCountUsers() {
        List<City> cities = citiesRepository.findAll();
        Map<City, Integer> map = this.getCitiesWithCountUsers(cities);

        return map;
    }

    @Override
    public Map<City, Integer> getAllCitiesByTemperature(String side, Integer temperature) {
        List<City> cities = citiesRepository.findAll();
        List<City> filtredCities = new ArrayList<>();

        if (cities != null) {
            for (City city : cities) {
                if ((side.equals("great") && city.getTemperature() > temperature) || (side.equals("less") && city.getTemperature() < temperature)) {
                    filtredCities.add(city);
                }
            }
        }

        Map<City, Integer> map = this.getCitiesWithCountUsers(filtredCities);
        return map;
    }
}
