package ru.pcs.weatherbroker.forms;

import lombok.Data;
import ru.pcs.weatherbroker.models.City;

import javax.management.relation.Role;

@Data
public class UserFormForAdmin {
    String email;
    String firstName;
    String lastName;
    String role;
    City city;
    String telegramId;
}
