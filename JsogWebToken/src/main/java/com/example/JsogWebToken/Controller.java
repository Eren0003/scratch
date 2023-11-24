package com.example.JsogWebToken;

import com.example.JsogWebToken.Config.JwtUtil;
import com.example.JsogWebToken.Entity.AuthenticationRequest;
import com.example.JsogWebToken.Entity.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authencticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (authenticationRequest.getUserName(),authenticationRequest.getPassword()));

        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect UserName or Password",e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
