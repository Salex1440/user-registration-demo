package com.example.userregistrationdemo.controller;

import com.example.userregistrationdemo.entity.User;
import com.example.userregistrationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/login")
    public String loginForm(WebRequest request, Model model) {
        System.out.println("GET login");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
}
