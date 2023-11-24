package com.example.springbootjdbc.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorDao actorDao;
    public void addActor(Actor actor) {
        actorDao.insertActor(actor);
    }
}
