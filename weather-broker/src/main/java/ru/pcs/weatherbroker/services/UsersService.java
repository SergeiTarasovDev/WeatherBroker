package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;

import java.util.List;

public interface UsersService {
    User getUser(Integer userId);
    List<User> getAllUsers();

    /*void addUser(UserForm form);
    void deleteUser(Integer userId);
    List<Car> getCarsByUser(Integer userId);
    List<Car> getCarsWithoutOwner();
    void addCarToUser(Integer userId, Integer carId);
    void update(Integer userId, UserForm userForm);*/
}
