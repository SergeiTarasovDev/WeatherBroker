package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.UserForm;
import ru.pcs.weatherbroker.forms.UserFormForAdmin;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.CitiesRepository;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final CitiesRepository citiesRepository;

    @Override
    public User getUser(Integer userId) {
        return usersRepository.findUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<User> getUserByCity(Integer cityId) {
        List<User> users = this.getAllUsers();
        List<User> filtredUsers = new ArrayList<>();

        if (users != null) {
            for (User user : users) {
                if (user.getCity().getId() == cityId) {
                    filtredUsers.add(user);
                }
            }
        }

        return filtredUsers;
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public void updateUser(Integer userId, UserForm userForm) {
        User user = usersRepository.getById(userId);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setHashPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setCity(userForm.getCity());
        usersRepository.save(user);
    }

    @Override
    public void updateUserForAdmin(Integer userId, UserFormForAdmin userFormForAdmin) {
        User user = usersRepository.getById(userId);
        user.setFirstName(userFormForAdmin.getFirstName());
        user.setLastName(userFormForAdmin.getLastName());
        user.setEmail(userFormForAdmin.getEmail());
        user.setCity(userFormForAdmin.getCity());
//        user.setRole(User.Role.valueOf(userFormForAdmin.getRole().toString()));
        usersRepository.save(user);
    }
}
