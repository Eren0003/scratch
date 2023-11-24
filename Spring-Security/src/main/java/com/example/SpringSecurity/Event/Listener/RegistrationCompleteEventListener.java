package com.example.SpringSecurity.Event.Listener;

import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.Event.RegistrationCompleteEvent;
import com.example.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
             User user =  event.getUser();
             String token = UUID.randomUUID().toString();
             userService.saveVerficationTokenForUser(token,user);
             String url = event.getApplicationUrl()+"verifyRegistration?token"+token;
    }
}
