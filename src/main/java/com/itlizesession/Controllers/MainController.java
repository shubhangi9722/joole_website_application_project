package com.itlizesession.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.annotation.WebServlet;

@WebServlet("")
@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage() {
        System.out.println("Main controller");
        return "index";
    }
}
