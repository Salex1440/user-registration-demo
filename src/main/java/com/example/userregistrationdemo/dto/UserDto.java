package com.example.userregistrationdemo.dto;

import com.example.userregistrationdemo.annotation.PasswordMatches;
import com.example.userregistrationdemo.annotation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    private String matchingPassword;

    @NotNull
    @NotEmpty
//    @ValidEmail
    private String email;

}
