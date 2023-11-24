package com.example.demo.web;

import com.example.demo.document.User;
import com.example.demo.dto.SignupDto;
import com.example.demo.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserDetailsManager userDetailsManager;
    @Autowired
    private TokenGenerator tokenGenerator;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody SignupDto signupDto){
        User user  = new User(signupDto.getUsername(), signupDto.getPassword());
        userDetailsManager.createUser(user);
        Authentication authentication = UsernamePasswordAuthenticationToken
                .authenticated(user,signupDto.getPassword(),Collections.EMPTY_LIST);
        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

}
