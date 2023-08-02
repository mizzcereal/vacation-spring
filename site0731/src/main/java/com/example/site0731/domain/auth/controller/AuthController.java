package com.example.site0731.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(HttpSession session) {

        Object attribute = session.getAttribute("idx");

        Long idx = (Long) attribute;

        System.out.println(idx);
        return "login";
    }

    @GetMapping("/join")
    public String join() {

        return "join";
    }

}
