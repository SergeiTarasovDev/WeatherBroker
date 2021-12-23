package ru.pcs.weatherbroker.services;

import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.forms.UserFormForAdmin;
import ru.pcs.weatherbroker.models.User;

import java.util.List;

public interface UsersService {
    User getUser(Integer userId);
    List<User> getAllUsers();
    void deleteUser(Integer userId);
    void updateUser(Integer userId, UserForm userForm);
    void updateUserForAdmin(Integer userId, UserFormForAdmin userFormForAdmin);
    List<User> getUserByCity(Integer cityId);
}
