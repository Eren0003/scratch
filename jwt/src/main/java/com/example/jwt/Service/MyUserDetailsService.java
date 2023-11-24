package com.example.jwt.Service;

import com.example.jwt.Entity.UserInfo;
import com.example.jwt.Repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByUserName(username);
       return    userInfo.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found "+username));
    }
}
