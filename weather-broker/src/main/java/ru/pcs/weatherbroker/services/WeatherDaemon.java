package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class WeatherDaemon extends Thread {

    @Autowired
    CitiesService citiesService;
    @Autowired
    WeatherService weatherService;

    @Override
    public synchronized void run() {
        while (true) {
            try {
                System.out.println("while:");
                List<City> cities = citiesService.getAllCities();
                System.out.println(cities.toString());
                for (City city : cities) {
                    System.out.println("   for:");

                    String unparsedWeather = weatherService.getWeather(city.getCityName());
                    Map<String, String> weather = weatherService.parseJson(unparsedWeather);
                    System.out.println("Получил погоду для " + city.getCityName());
                    weatherService.update(city, weather);
                    WeatherDaemon.sleep(1000);


                }
            } catch (NullPointerException e) {
                System.out.println("Ошибка, ждем");
                try {
                    WeatherDaemon.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("Ошибка при ожидании");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
