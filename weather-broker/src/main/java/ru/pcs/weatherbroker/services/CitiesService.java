package ru.pcs.weatherbroker.services;

import netscape.javascript.JSUtil;

import java.util.*;

public class CitiesService {

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
