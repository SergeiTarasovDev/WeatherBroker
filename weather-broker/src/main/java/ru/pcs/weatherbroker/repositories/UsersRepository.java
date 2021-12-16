package ru.pcs.weatherbroker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.weatherbroker.models.User;
import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
