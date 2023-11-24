package com.example.oauthjwt.Service;

import com.example.oauthjwt.Entity.CustomUser;
import com.example.oauthjwt.Entity.UserPojo;
import com.example.oauthjwt.Repo.UserPojoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserPojoRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPojo user = null;
        try{
            user = repo.findByUsername(username);
            CustomUser customUser = new CustomUser(user);
            return customUser;
        }
        catch(Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException(username + " Not Found");
        }
    }
}
