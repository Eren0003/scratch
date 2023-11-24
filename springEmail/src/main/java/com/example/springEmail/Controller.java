package com.example.springEmail;

import com.example.springEmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private EmailService emailService;
    @PostMapping("/rest")
    public void sentMail(){
        emailService.sendEmail("eka29042@gmail.com","SUBJECT","Hi...");
    }
}
