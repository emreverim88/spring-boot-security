package main.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/home")
    public String hello() {
        return "home";
    }

}
