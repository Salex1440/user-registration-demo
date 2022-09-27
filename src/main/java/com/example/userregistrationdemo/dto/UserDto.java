package com.example.userregistrationdemo.dto;

import com.example.userregistrationdemo.annotation.PasswordMatches;
import com.example.userregistrationdemo.annotation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches(message = "Passwords don't match!")
public class UserDto {
    @NotEmpty(message = "Nickname cannot be empty.")
    private String nickname;

    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    private String matchingPassword;

    @NotEmpty(message = "Email cannot be empty!")
    @ValidEmail(message = "Invalid email!")
    private String email;

}
