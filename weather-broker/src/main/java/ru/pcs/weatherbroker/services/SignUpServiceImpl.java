package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.SignUpForm;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.CitiesRepository;
import ru.pcs.weatherbroker.repositories.UsersRepository;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final CitiesRepository citiesRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        if (!form.getEmail().equals("") || form.getCity() != null || !form.getPassword().equals("")) {
            User user = User.builder()
                    .firstName(form.getFirstName())
                    .lastName(form.getLastName())
                    .email(form.getEmail())
                    .role(User.Role.USER)
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .city(form.getCity())
                    .telegramId(form.getTelegramId())
                    .build();
            usersRepository.save(user);
        }
    }
}
