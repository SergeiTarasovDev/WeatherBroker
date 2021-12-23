package ru.pcs.weatherbroker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.weatherbroker.forms.SignUpForm;
import ru.pcs.weatherbroker.models.City;
import ru.pcs.weatherbroker.services.CitiesService;
import ru.pcs.weatherbroker.services.SignUpService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;
    private final CitiesService citiesService;

    @GetMapping
    public String getSignUpPage(Model model) {
        List<City> cities = citiesService.getAllCities();
        model.addAttribute("cities", cities);
        return "signUp";
    }

    @PostMapping
    public String signUpUser(SignUpForm form) {
        signUpService.signUpUser(form);
        return "signIn";
    }

}
