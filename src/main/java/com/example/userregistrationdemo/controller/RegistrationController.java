package com.example.userregistrationdemo.controller;

import com.example.userregistrationdemo.dto.UserDto;
import com.example.userregistrationdemo.entity.User;
import com.example.userregistrationdemo.exception.UserAlreadyExistsException;
import com.example.userregistrationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        System.out.println("GET registration");
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registerUserAccount(
            @ModelAttribute("userDto") @Valid UserDto userDto,
            BindingResult result,
            HttpServletRequest request,
            Errors errors) {
        System.out.println("POST registration");
        if (result.hasErrors()) {
            return "registration";
        }
        try {
            User registered = userService.registerNewAccount(userDto);
        } catch (UserAlreadyExistsException uaeEx) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("message", "An account for that username/email already exists.");
            return "registration";
        }
        return "registration";
//        return new ModelAndView("successRegister", "userDto", userDto);
    }

}
