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

    private final CitiesRepository citiesRepository;
    private final UsersRepository usersRepository;

    public void addCity(CityForm form) {
        try {
            String result = WeatherService.getWeather(form.getCityName());
            Map<String, String> weather = parseJson(result);

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
    public void deleteUser(City city) {
        citiesRepository.delete(city);
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

    @Override
    public Map<String, String> parseJson(String text) {

        Map<String, String> result = new HashMap<>();

        text = text.replaceAll("\"", "");
        text = text.replaceAll("\\:\\{", "");
        text = text.replaceAll("\\{", "");
        text = text.replaceAll("\\}", "");

        System.out.println(text);

        String firstPart;
        String secondPart;

        for (String line : text.split(",")) {
            firstPart = line.split(":")[0];
            secondPart = line.split(":")[1];
            switch (firstPart) {
                case "maintemp":
                    result.put("temperature", secondPart);
                    break;
                case "pressure":
                    double temp = Math.round(Integer.parseInt(secondPart) * 750.06 / 10);
                    String pressure = (temp / 100) + " ";
                    result.put("pressure", pressure);
                    break;
                case "humidity":
                    result.put("humidity", secondPart);
                    break;
                case "windspeed":
                    result.put("windSpeed", secondPart);
                    break;
                case "deg":
                    result.put("windDeg", secondPart);
                    break;
            }
        }

        return result;
    }


}
