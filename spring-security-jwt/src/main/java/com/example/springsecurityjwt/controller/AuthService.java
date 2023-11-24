package com.example.springsecurityjwt.controller;
import com.example.springsecurityjwt.Entity.User;
import com.example.springsecurityjwt.Repo.UserRepo;
import com.example.springsecurityjwt.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
      var user = User.builder()
              .userName(request.getUserName())
              .email(request.getEmail())
              .pass(passwordEncoder.encode(request.getPassword()))
              .build();
      userRepo.save(user);
      var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           request.getUserName(),
                           request.getPassword()
                   )
           );
           var user = userRepo.findByUserName(request.getUserName())
                   .orElseThrow();
           var jwtToken = jwtService.generateToken(user);
           return AuthenticationResponse.builder()
                   .token(jwtToken)
                   .build();
    }
}
