package com.example.security.Service;

import com.example.security.Entity.Security;
import com.example.security.Entity.MyUserDetails;
import com.example.security.Repo.SecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SecurityRepo securityRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
     return  securityRepo
             .findByUserName(userName)
             .map(MyUserDetails::new)
             .orElseThrow(()->new UsernameNotFoundException("userNotFound :"+userName));

//     security.orElseThrow(()-> new UsernameNotFoundException("not found "+userName));
//     return security.map(MyUserDetails::new).get();
    }
    public Security addUser(Security security){
        security.setPassword(passwordEncoder.encode(security.getPassword()));
       return securityRepo.save(security);
    }


}