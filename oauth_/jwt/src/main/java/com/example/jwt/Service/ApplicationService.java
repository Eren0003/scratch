package com.example.jwt.Service;

import com.example.jwt.Entity.UserInfo;
import com.example.jwt.Repository.UserInfoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class ApplicationService {
    @Autowired
    private UserInfoRepo repo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private PasswordEncoder encoder;
    public UserInfo register(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return repo.save(userInfo);
    }


    public void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;
        Map<String ,String> tokenMap = new HashMap<>();
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            userName = jwtService.extractUserName(token);
        }
        if(userName != null){
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);
            if(jwtService.isTokenValid(token,userDetails)){
                String accessToken =  jwtService.generateAccessToken(userName);
                tokenMap.put("AccessToken",accessToken);
                response.setContentType("APPLICATION_JSON_VALUE");
                new ObjectMapper().writeValue(response.getOutputStream(),tokenMap);
            }
        }
    }

}
