package ru.pcs.weatherbroker.forms;

import lombok.Data;

@Data
public class CityForm {
    private String cityName;
    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;
    private Integer windDeg;
}
