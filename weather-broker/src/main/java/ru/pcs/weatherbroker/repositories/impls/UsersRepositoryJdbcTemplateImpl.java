package ru.pcs.weatherbroker.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into user(email, hash_password, first_name, last_name, city_id) values (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from user order by id";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<User> userRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String email = row.getString("email");
        String hashPassword = row.getString("hash_password");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");

        City city = new City();

        return new User(id, email, hashPassword, firstName, lastName, city);
    };

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(SQL_INSERT, user.getFirstName(), user.getLastName());
    }

    @Override
    public List<User> findAllByCityId_Id(Integer cityId) {
        return null;
    }
}
