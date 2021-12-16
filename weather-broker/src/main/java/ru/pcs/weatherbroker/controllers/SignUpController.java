package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.SignUpForm;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;
import ru.pcs.weatherbroker.services.SignUpService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sign_up")
public class SignUpController {

/*    @Autowired
    private UsersRepository usersRepository;*/

    /*@PostMapping("/users") //28 - 23
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        usersRepository.save(user);

        return "redirect:/user_add.html";
    }*/

//    private final SignUpService signUpService; //32

    /*@GetMapping
    public String getSignUpPage() {
        return "sign_up";
    }*/

/*    @PostMapping
    public String signUpUser(SignUpForm form) {
        signUpService.signUpUser(form);
        return "redirect:/sidn_in";

    }

 */
}
