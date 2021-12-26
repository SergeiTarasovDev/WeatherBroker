package ru.pcs.weatherbroker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("")
    public String getSignPageOnStartup() {
        return "redirect:/signIn";
    }

    @GetMapping("/signIn")
    public String getSignPage() {
        return "signIn";
    }

}
