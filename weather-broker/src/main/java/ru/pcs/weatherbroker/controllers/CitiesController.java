package ru.pcs.weatherbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;

import java.util.List;

@Controller
public class CitiesController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/cities")
    public String getAllCities() {
        return "cities";
    }

    @GetMapping("/cities/{city-id}/users")
    public String getUserOfCity(@PathVariable("city-id") Integer cityId, Model model) {
        System.out.println(cityId);
        List<User> users = usersRepository.findAllByCityId_Id(cityId);
        model.addAttribute("usersOfCity", users);
        return "city_users";
    }


}