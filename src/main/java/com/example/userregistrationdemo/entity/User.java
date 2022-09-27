package com.example.userregistrationdemo.entity;

import com.example.userregistrationdemo.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickname;

    private String email;

    private String password;

    public User() {}

    public User(UserDto userDto) {
        this.nickname = userDto.getNickname();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }
}
