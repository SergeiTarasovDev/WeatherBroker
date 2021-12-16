package ru.pcs.weatherbroker.forms;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class UserForm {
    String email;
    String password;
    String firstName;
    String lastName;
}
