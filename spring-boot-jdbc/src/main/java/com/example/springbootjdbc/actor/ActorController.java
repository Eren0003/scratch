package com.example.springbootjdbc.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/actor")
public class ActorController {
    @Autowired
    private ActorService service;
    @PostMapping
    public void addActor(@RequestBody Actor actor){
         service.addActor(actor);
    }

}
