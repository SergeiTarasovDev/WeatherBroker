package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.CitiesRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class WeatherService {
    private static final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    CitiesRepository citiesRepository;

    /**
     * The method gets the weather in the city by the zip-code from API OpenWeather
     * Example requests:
     *  - by city id: api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}
     *  - by zip-code: api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}&appid={API key}
     * @param cityName city name by which you need to get data
     * @throws Exception
     */
    public static String getWeather(String cityName) throws Exception {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",ru&callback=test&lang=ru&appid=cf24ec3cb89a0e6975864d4439b03f69&units=metric";

        URL objUrl = new URL(url);

        HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
//        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

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

    public void update(City city, Map<String, String> weather) {
        System.out.print(city.getTemperature() + " -> ");
        city.setTemperature(Double.parseDouble(weather.get("temperature")));
        city.setPressure(Double.parseDouble(weather.get("pressure")));
        city.setHumidity(Integer.parseInt(weather.get("humidity")));
        city.setWindSpeed(Double.parseDouble("windSpeed"));
        city.setWindDeg(Integer.parseInt("windDeg"));
        System.out.println(weather.get("temperature"));

        citiesRepository.save(city);
    }


}
