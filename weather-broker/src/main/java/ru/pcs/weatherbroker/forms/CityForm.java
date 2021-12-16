package ru.pcs.weatherbroker.forms;

import lombok.Data;

@Data
public class CityForm {
    private String cityName;
    private Double currentTemperature;
}
