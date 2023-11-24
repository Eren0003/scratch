package com.example.jwt.Repository;

import com.example.jwt.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {

 Optional<UserInfo> findByUserName(String userName);
}
