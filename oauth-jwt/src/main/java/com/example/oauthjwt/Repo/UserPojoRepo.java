package com.example.oauthjwt.Repo;

import com.example.oauthjwt.Entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPojoRepo extends JpaRepository<UserPojo,String> {

   @Query(value = "select * from user_pojo",nativeQuery = true)
    public UserPojo findByUsername(String username);
}
