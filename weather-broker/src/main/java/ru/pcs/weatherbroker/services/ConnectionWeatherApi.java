package ru.pcs.weatherbroker.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectionWeatherApi {
    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * The method gets the weather in the city by the zip-code from API OpenWeather
     * Example requests:
     *  - by city id: api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}
     *  - by zip-code: api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}&appid={API key}
     * @param cityName city name by which you need to get data
     * @throws Exception
     */

    public Map<String, String> getWeather(String cityName) throws Exception {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",ru&callback=test&lang=ru&appid=cf24ec3cb89a0e6975864d4439b03f69&units=metric";

        URL objUrl = new URL(url);

        HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        CitiesService citiesService = new CitiesService();
        Map<String, String> result = citiesService.parseJson(response.toString());

        return result;
    }

}
