package ru.pcs.weatherbroker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.weatherbroker.models.User;
import ru.pcs.weatherbroker.repositories.UsersRepository;

@RequiredArgsConstructor
@Component
public class AccountServiceImpl implements AccountService {

    private final UsersRepository usersRepository;
    private final WeatherService weatherService;

    @Override
    public String getAuthorizedUserPage(Integer userId) {
        weatherService.getNewWeather();

        User user = usersRepository.getById(userId);
        String userRole = user.getRole().toString();
        if (userRole.equals("ADMIN")) {
            return "redirect:/administrator/cities";
        }
        return "account";
    }
}
