package com.example.userregistrationdemo.annotation;

import com.example.userregistrationdemo.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserDto userDto = (UserDto) value;
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }
}
