package com.example.userregistrationdemo.controller;

import com.example.userregistrationdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String loginForm(WebRequest request, Model model) {
        System.out.println("GET login");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
}
