package ru.pcs.weatherbroker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.CityForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;

import java.util.*;


@Component
public class CitiesServiceImpl implements CitiesService {

    private final CitiesRepository citiesRepository;

    @Autowired
    public CitiesServiceImpl(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

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
    public Optional<City> getCity(Integer cityId) {
        return citiesRepository.findById(cityId);
    }

    @Override
    public void updateCity(Integer cityId) {
        System.out.println("update");
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
