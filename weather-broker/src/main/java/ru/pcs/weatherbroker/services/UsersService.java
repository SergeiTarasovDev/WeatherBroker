package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;

import java.util.List;

public interface UsersService {
    User getUser(Integer userId);
    List<User> getAllUsers();
    void deleteUser(Integer userId);
    void update(Integer userId, UserForm userForm);

    /*void addUser(UserForm form);

    List<Car> getCarsByUser(Integer userId);
    List<Car> getCarsWithoutOwner();
    void addCarToUser(Integer userId, Integer carId);
    void update(Integer userId, UserForm userForm);*/
}
