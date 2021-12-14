package ru.pcs.weatherbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherBrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherBrokerApplication.class, args);
        System.out.println("\n------------------------> Application is run <------------------------");
    }

}
