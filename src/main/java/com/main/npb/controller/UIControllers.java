package com.main.npb.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIControllers {

    private static final Logger log = LoggerFactory.getLogger(UIControllers.class);

    @GetMapping("/")
    public String landingPage(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String referer = request.getHeader("Referer");

        // Log or save to database
        log.info("Visitor: IP={}, UA={}, Referer={}", ip, userAgent, referer);

        return "index";
    }

}
