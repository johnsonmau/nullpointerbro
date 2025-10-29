package com.main.dashboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIControllers {


    @GetMapping("/")
    public String landingPage(Model model) {
        return "";
    }

}
