package ru.pcs.weatherbroker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.weatherbroker.models.City;

public interface CitiesRepository extends JpaRepository<City, Integer> {
    City findCityById(Integer cityId);
}
