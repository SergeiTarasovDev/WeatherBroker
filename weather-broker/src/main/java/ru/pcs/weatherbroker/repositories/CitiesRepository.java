package ru.pcs.weatherbroker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.weatherbroker.models.City;
import java.util.List;

public interface CitiesRepository extends JpaRepository<City, Integer> {
    City findCityById(Integer cityId);
    List<City> findCityByTemperatureGreaterThan(Double temperature);
    List<City> findCityByTemperatureLessThan(Double temperature);
}
