package ru.pcs.weatherbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import ru.pcs.weatherbroker.services.WeatherDaemon;

@SpringBootApplication
public class WeatherBrokerApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {

        SpringApplication.run(WeatherBrokerApplication.class, args);
        System.out.println("\n------------------------> Application is run <------------------------");

        // todo: исправить ошибку запуска демона
        /*WeatherDaemon weatherDaemon = new WeatherDaemon();
        weatherDaemon.setDaemon(true);
        weatherDaemon.start();*/
    }

}
