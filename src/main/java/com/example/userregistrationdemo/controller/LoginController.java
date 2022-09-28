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

    @PostMapping(path = "/login")
    public ModelAndView signIn(@ModelAttribute("user") User input,
                               BindingResult result,
                               Errors errors) {
        if (result.hasErrors()) {
            return new ModelAndView("login", "errors", errors.getAllErrors());
        }
        User user = userService.findUserByNickname(input.getNickname());
        if (user == null) {
            return new ModelAndView("login", "message", "User with such nickname doesn't exist!");
        }
        if (!input.getPassword().equals(user.getPassword())) {
            return new ModelAndView("login", "message", "Wrong password!");
        }
        return new ModelAndView("home", "user", user);
    }
}
