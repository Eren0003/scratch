package com.example.security.Repo;

import com.example.security.Entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepo extends JpaRepository<Security,String> {

    Optional<Security> findByUserName(String userName);

}
