package ru.pcs.weatherbroker.forms;

import lombok.Data;
import ru.pcs.weatherbroker.models.City;

@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private City city;
    private String telegramId;
}

