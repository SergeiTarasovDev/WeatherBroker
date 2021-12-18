package ru.pcs.weatherbroker.forms;

import lombok.Data;

@Data
public class UserForm {
    String email;
    String password;
    String firstName;
    String lastName;
}
