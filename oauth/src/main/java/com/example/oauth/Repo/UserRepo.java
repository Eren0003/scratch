package com.example.oauth.Repo;

import com.example.oauth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
