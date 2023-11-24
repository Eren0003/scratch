package com.example.ExceptionHandling.Controller;

import com.example.ExceptionHandling.Advice.ResourceNotFoundException;
import com.example.ExceptionHandling.Dto.UserRequest;
import com.example.ExceptionHandling.Entity.User;
import com.example.ExceptionHandling.Repo.UserRepository;
import com.example.ExceptionHandling.Service.ApplicationService;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService service;
    @Autowired
    private UserRepository repository;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRequest request){
        try {
            return new ResponseEntity<>(service.saveUser(request), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/finduser/{id}")
    public User findUser(@PathVariable(value = "id")int id) throws Exception{
        return this.repository.findById(id)
                    .orElseThrow(()->new UserPrincipalNotFoundException("UserNotFound"));
    }
    @GetMapping("/findAllUser")
    public String getAllUser() {
        throw new ResourceNotFoundException(601,"user not found");
    }
}
