package com.example.jwt.Config;

import com.example.jwt.Filter.JwtAuthFilter;
import com.example.jwt.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ApplicationConfig {
    @Autowired
    private JwtAuthFilter authFilter;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.builder()
//                .username("eka")
//                .password(encoder.encode("eka"))
//                .roles("ADMIN")
//                .build();
//
//
        return new MyUserDetailsService();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.csrf().disable()
                .authorizeHttpRequests()
               .requestMatchers("/new","").permitAll()
               .requestMatchers("/refresh").permitAll()
               .requestMatchers("/welcome").permitAll()
               .requestMatchers("/authenticate").permitAll()
//               .requestMatchers("/admin").hasRole("ROLE_ADMIN")
//               .requestMatchers("/user").hasAnyRole("ROLE_ADMIN","ROLE_USER")
               .anyRequest().authenticated()
//             .and().formLogin()
               .and().sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and().authenticationProvider(authenticationProvider())
               .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();

    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService());
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
