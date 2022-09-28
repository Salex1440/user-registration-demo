package com.example.userregistrationdemo.entity;

import com.example.userregistrationdemo.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public User() {}

    public User(UserDto userDto) {
        this.nickname = userDto.getNickname();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }
}
