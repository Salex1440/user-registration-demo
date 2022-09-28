package com.example.userregistrationdemo.service;

import com.example.userregistrationdemo.dto.UserDto;
import com.example.userregistrationdemo.entity.User;
import com.example.userregistrationdemo.exception.UserAlreadyExistsException;
import com.example.userregistrationdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User registerNewAccount(UserDto userDto) throws UserAlreadyExistsException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email address: "
                    + userDto.getEmail());
        }
        User user = new User(userDto);
        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with nickname" + username + "doesn't exist!");
        }
        return null;
    }
}
