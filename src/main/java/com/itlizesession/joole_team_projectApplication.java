package com.itlizesession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class joole_team_projectApplication {
    public static void main(String[] args) {
        SpringApplication.run(joole_team_projectApplication.class, args);
    }
}
