package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.repositories.CitiesRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class WeatherService {
    private static final String USER_AGENT = "Mozilla/5.0";

    private final CitiesRepository citiesRepository;

    /**
     * The method gets the weather in the city by the zip-code from API OpenWeather
     * Example requests:
     *  - by city id: api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}
     *  - by zip-code: api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}&appid={API key}
     *  Example: http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",ru&callback=test&lang=ru&appid=cf24ec3cb89a0e6975864d4439b03f69&units=metric
     * @param cityName city name by which you need to get data
     * @throws Exception
     */
    public String getWeather(String cityName) {
        cityName = cityName.trim();
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&callback=test&lang=ru&appid=cf24ec3cb89a0e6975864d4439b03f69&units=metric";
        try {
            URL objUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            System.err.println("Weather API:" + e);
            return "-1";
        }
    }

    public Map<String, String> parseJson(String text) {
        Map<String, String> result = new HashMap<>();

        text = text.replaceAll("\"", "");
        text = text.replaceAll("\\:\\{", "");
        text = text.replaceAll("\\{", "");
        text = text.replaceAll("\\}", "");
        text = text.replaceAll("]", "");

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
                case "icon":
                    result.put("icon", secondPart);
                    break;
            }
        }

        return result;
    }

    public void updateWeather(City city, Map<String, String> weather) {
        System.out.println(city.getCityName());
        System.out.println(city.getTemperature() + ", " + city.getPressure() + ", " + city.getHumidity() + ", " + city.getWindSpeed() + ", " + city.getWindDeg() + ", " + city.getIcon());
        city.setTemperature((int) Math.round(Double.parseDouble(weather.get("temperature"))));
        city.setPressure(Double.parseDouble(weather.get("pressure")));
        city.setHumidity(Integer.parseInt(weather.get("humidity")));
        city.setWindSpeed(Double.parseDouble(weather.get("windSpeed")));
        city.setWindDeg(Integer.parseInt(weather.get("windDeg")));
        city.setIcon(weather.get("icon"));
        System.out.println(city.getTemperature() + ", " + city.getPressure() + ", " + city.getHumidity() + ", " + city.getWindSpeed() + ", " + city.getWindDeg() + ", " + city.getIcon());

        citiesRepository.save(city);
    }

    @Async
    public void getNewWeather() {
        while (true) {
            List<City> cities = citiesRepository.findAll();

            try {
                    for (City city : cities) {
                        String unparsedWeather = this.getWeather(city.getCityName());
                        if (unparsedWeather.equals("-1")) {
                            break;
                        }
                        Map<String, String> weather = this.parseJson(unparsedWeather);

                        this.updateWeather(city, weather);
                        Thread.sleep(20000);
                    }
            } catch (Exception e) {
                System.out.println("Ошибка получения погоды: " + e);
            }
        }
    }
}
