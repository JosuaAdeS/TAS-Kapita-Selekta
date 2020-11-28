package com.metrodata.tas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasApplication.class, args);
    }

    @Bean //Inversion of Control
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
