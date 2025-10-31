package com.main.npb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
public class UIControllers {

    private static final Logger log = LoggerFactory.getLogger(UIControllers.class);

    @GetMapping("/privacy")
    public String privacyPage(){
        return "privacy";
    }

    @GetMapping("/terms")
    public String termsPage(){
        return "terms";
    }

    @GetMapping("/")
    public String landingPage(HttpServletRequest request) {

        String realIp = request.getHeader("X-Forwarded-For");
        if (realIp != null && realIp.contains(",")) {
            realIp = realIp.split(",")[0].trim();
        } else if (realIp == null) {
            realIp = request.getHeader("X-Real-IP");
        }

        String ip = realIp;
        String userAgent = request.getHeader("User-Agent");
        String referer = request.getHeader("Referer");

        if (!userAgent.contains("Uptime-Kuma")){
            // Log or save to database
            log.info("Visitor: IP={}, User Agent={}, Referer={}", ip, userAgent, referer);
        }

        return "index";
    }

}
