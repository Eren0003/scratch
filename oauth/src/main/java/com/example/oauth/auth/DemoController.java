package com.example.oauth.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/get")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("hello");
    }
}
