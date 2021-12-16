package ru.pcs.weatherbroker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.weatherbroker.models.User;
import java.util.List;

public interface UsersRepository {
    List<User> findAllByCityId_Id(Integer cityId);
//    public void setUser(User user);

    //public List<User> findAll();

    public void save(User user);

}
