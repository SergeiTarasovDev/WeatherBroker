package ru.pcs.weatherbroker.forms;

import lombok.Data;

@Data
public class CityForm {
    private String cityName;
    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;
    private Integer windDeg;
    private String icon;
}
