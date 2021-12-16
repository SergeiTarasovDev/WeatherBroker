package ru.pcs.weatherbroker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    private Double temperature;
    private Double pressure;
    private Integer humidity;
    private Double windSpeed;
    private Integer windDeg;
}
