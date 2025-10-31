package com.main.npb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UIControllers {

    private static final Logger log = LoggerFactory.getLogger(UIControllers.class);

    @GetMapping("/test")
    public String testIp(HttpServletRequest request) {
        Map<String, String> info = new HashMap<>();

        // Get the real IP from headers NPM sends
        info.put("X-Real-IP", request.getHeader("X-Real-IP"));
        info.put("X-Forwarded-For", request.getHeader("X-Forwarded-For"));
        info.put("RemoteAddr", request.getRemoteAddr()); // This will still be 172.17.0.1

        // Optional: See backend info
        info.put("X-Backend-Server", request.getHeader("X-Backend-Server"));
        info.put("X-Backend-Port", request.getHeader("X-Backend-Port"));
        info.put("X-Backend-Scheme", request.getHeader("X-Backend-Scheme"));

        // Extract the real IP
        String realIp = request.getHeader("X-Forwarded-For");
        if (realIp != null && realIp.contains(",")) {
            realIp = realIp.split(",")[0].trim();
        } else if (realIp == null) {
            realIp = request.getHeader("X-Real-IP");
        }

        info.put("REAL_CLIENT_IP", realIp);

        // Log as string
        String logString = info.toString();
        System.out.println("IP Info: " + logString);

        // Or format it nicely:
        StringBuilder sb = new StringBuilder("IP Information:\n");
        for (Map.Entry<String, String> entry : info.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        String formattedLog = sb.toString();
        System.out.println(formattedLog);

        return "index";
    }


    @GetMapping("/")
    public String landingPage(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String referer = request.getHeader("Referer");

        if (!userAgent.contains("Uptime-Kuma")){
            // Log or save to database
            log.info("Visitor: IP={}, User Agent={}, Referer={}", ip, userAgent, referer);
        }

        return "index";
    }

}
