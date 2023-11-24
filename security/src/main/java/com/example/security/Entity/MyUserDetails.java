package com.example.security.Entity;

import com.example.security.Entity.Security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {



//    private String userName;
//    private String password;
//    private boolean active;
//    private List<GrantedAuthority> authorities ;
//    public MyUserDetails(Security security){
//      this.userName = security.getUserName();
//      this.password = security.getPassword();
//      this.active = security.isActive();
//      this.authorities = Arrays.stream(security.getUserRole().split(","))
//              .map(SimpleGrantedAuthority::new)
//              .collect(Collectors.toList());
//    }

    private Security security;

    public MyUserDetails (Security security){
        this.security= security;
    }
    public MyUserDetails(){
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(security
                .getUserRole()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return security.getPassword();
    }

    @Override
    public String getUsername() {
        return security.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
