package com.example.jwt.Controller;

import com.example.jwt.Response.AuthRequest;
import com.example.jwt.Entity.UserInfo;
import com.example.jwt.Service.ApplicationService;
import com.example.jwt.Service.JwtService;
import com.example.jwt.Service.MyUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ApplicationController {
    @Autowired
    private ApplicationService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private AuthenticationManager authManager;

    @RequestMapping("/welcome")
    public String welcome (){
        return "welcome";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public String admin(){
        return "welcome admin";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping("/user")
    public String user(){
        return "welcome user";
    }
    @PostMapping("/new")
    public UserInfo register(@RequestBody UserInfo userInfo ){
        return service.register(userInfo);
    }
    @PostMapping("/authenticate")
    public void authenticate(@RequestBody AuthRequest auth , HttpServletResponse response) throws UsernameNotFoundException{
      try{
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPass()));
       if(authenticate.isAuthenticated()) {
           String accessToken = jwtService.generateAccessToken(auth.getUserName());
           String refreshToken = jwtService.generateRefreshToken(auth.getUserName());
           Map<String ,String> token = new HashMap<>();
           token.put("AccessToken",accessToken);
           token.put("RefreshToken",refreshToken);
           response.setContentType("APPLICATION_JSON_VALUE");
           new ObjectMapper().writeValue(response.getOutputStream(),token);
       }
      }
       catch(Exception e){
            throw new UsernameNotFoundException("UserNotFound :");
       }
    }
    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request,HttpServletResponse response) throws IOException {
         service.refresh(request,response);
    }
}
