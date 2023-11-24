package com.example.oauth.auth;

import com.example.oauth.dao.AuthenticateRequest;
import com.example.oauth.dao.AuthenticationResponse;
import com.example.oauth.dao.RegisterRequest;
import com.example.oauth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @GetMapping("/reg")
    public ResponseEntity<String> ans(){
        return ResponseEntity.ok("ans");
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
