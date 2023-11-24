package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.Event.RegistrationCompleteEvent;
import com.example.SpringSecurity.Model.UserModel;
import com.example.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResgistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @PostMapping("register")
    public String registerUser(@RequestBody UserModel userModel){

        User user = userService.registerUser(userModel);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(
                             user,
                "url"
        ));
        return "success";
    }
}
