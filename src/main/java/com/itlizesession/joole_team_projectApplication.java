package com.itlizesession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@EnableJpaAuditing
public class joole_team_projectApplication {
    @RequestMapping("/")
    public String showHomePage() {
        //System.out.println("Main controller");
        return "index";
    }
    public static void main(String[] args) {
        SpringApplication.run(joole_team_projectApplication.class, args);
    }
}
