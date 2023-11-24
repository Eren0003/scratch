package com.example.security.Controller;

import com.example.security.Entity.Security;
import com.example.security.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {
    @Autowired
    MyUserDetailsService service;

    @GetMapping("default")
    public String api (){
        return ("<h1>default</h1>");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin")
    public String admin (){
        return "admin";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("user")
    public String user(){
        return "userDetail";
    }
    @PostMapping("addUser")
    public Security addUser (@RequestBody Security security){
        return service.addUser(security);
    }
}
