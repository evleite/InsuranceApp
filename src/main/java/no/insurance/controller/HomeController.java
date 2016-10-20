package no.insurance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 20/10/2016.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {

        return "Case insurance contract project for Spring Boot";
    }
}