package com.example.oauthjwt.Entity;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
    public CustomUser(UserPojo userPojo) {
        super(userPojo.getUsername(),
                userPojo.getPassword(),
                userPojo.getListOfGrantedAuthority());
    }
}
