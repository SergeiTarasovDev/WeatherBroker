package ru.pcs.weatherbroker.forms;

import lombok.Data;
import ru.pcs.weatherbroker.models.City;

@Data
public class UserForm {
    String email;
    String password;
    String firstName;
    String lastName;
    City city;
    String telegramId;
}
