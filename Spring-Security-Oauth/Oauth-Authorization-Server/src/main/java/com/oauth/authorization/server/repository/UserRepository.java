package com.oauth.authorization.server.repository;

import com.oauth.authorization.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
