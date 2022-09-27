package com.example.userregistrationdemo.dto;

import com.example.userregistrationdemo.annotation.PasswordMatches;
import com.example.userregistrationdemo.annotation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches(message = "Passwords don't matches!")
public class UserDto {
    @NotEmpty(message = "User's name cannot be empty.")
    private String firstName;

    @NotEmpty(message = "User's name cannot be empty.")
    private String lastName;

    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    private String matchingPassword;

    @NotEmpty(message = "Email cannot be empty!")
    @ValidEmail(message = "Invalid email!")
    private String email;

}
