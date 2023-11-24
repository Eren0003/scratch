package com.example.springsecurityjwt.Repo;

import com.example.springsecurityjwt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);
}
