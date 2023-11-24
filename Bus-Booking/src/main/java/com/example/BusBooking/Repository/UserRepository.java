package com.example.BusBooking.Repository;

import com.example.BusBooking.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "SELECT * FROM user_table WHERE user_name = ?1",nativeQuery = true)
    User findByUser(String userName);

    @Query(value = "SELECT bus_number FROM  user_table ut WHERE user_name = ?1",nativeQuery = true)
    String findBusNumByUser(String userName);
    @Transactional
    @Modifying
    @Query(value = "delete from user_table where user_name = ?1",nativeQuery = true)
    void deleteUser(String userName);


    Optional<User> findByUserName(String userName);
}
