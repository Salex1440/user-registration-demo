package com.example.userregistrationdemo.repository;

import com.example.userregistrationdemo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@NonNull String email);
}
