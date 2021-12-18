package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public User getUser(Integer userId) {
        return usersRepository.findUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

}
