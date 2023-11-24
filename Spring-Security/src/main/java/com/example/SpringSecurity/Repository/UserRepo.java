package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepo extends JpaRepository<User,Long> {
}
