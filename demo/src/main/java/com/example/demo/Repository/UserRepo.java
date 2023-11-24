package com.example.demo.Repository;

import com.example.demo.document.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    
    Optional<User> findByUsername(String username);
    boolean existByUsername(String username);
}
