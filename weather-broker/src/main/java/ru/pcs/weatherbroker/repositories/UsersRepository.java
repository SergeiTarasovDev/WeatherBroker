package ru.pcs.weatherbroker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.weatherbroker.models.User;
import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {
    List<User> findAllByCityId_Id(Integer cityId);
//    public void setUser(User user);
}
