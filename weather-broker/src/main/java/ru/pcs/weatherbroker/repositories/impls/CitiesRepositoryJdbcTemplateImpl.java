package ru.pcs.weatherbroker.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.models.City;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CitiesRepositoryJdbcTemplateImpl implements CitiesRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into city(city_name, current_temperature) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from city order by id";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CitiesRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<City> cityRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String cityName = row.getString("city_name");
        Double currentTemperature = row.getDouble("current_temperature");
        System.out.println("RowMapper<City>");

        return new City(id, cityName, currentTemperature);
    };

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, cityRowMapper);
    }

    @Override
    public void save(City city) {
        System.out.println("save");
        jdbcTemplate.update(SQL_INSERT, city.getCityName(), city.getCurrentTemperature());
    }

}
