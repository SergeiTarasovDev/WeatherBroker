package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.forms.SignUpForm;
import ru.pcs.weatherbroker.repositories.UsersRepository;

// TODO: 32, 11:30
/*
@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {


    /*
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;


    @Override
    public void signUpUser(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(user);
    }


}
    */