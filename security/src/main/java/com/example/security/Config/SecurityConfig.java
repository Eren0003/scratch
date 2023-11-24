package com.example.security.Config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{
    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

       http.csrf().disable()
               .authorizeHttpRequests((auth)->{
                   auth.requestMatchers("/addUser").permitAll();
                   auth.requestMatchers("/default").permitAll();
                   auth.requestMatchers("/user").hasAnyRole("USER","ADMIN");
                   auth.requestMatchers("/admin").hasRole("ADMIN");
                   auth.anyRequest().authenticated();
                       })
               .userDetailsService(userDetailsService)
               .formLogin(Customizer.withDefaults());
        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails eka = User.builder()
//                .username("ekambaram")
//                .password(passwordEncoder().encode("eka"))
//                .roles("USER")
//                .build();
//        UserDetails deva = User.builder()
//                .username("deva")
//                .password(passwordEncoder().encode("kumar"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(deva,eka);
//    }
    public void config (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }





}
