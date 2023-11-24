package com.example.springbootjdbc.actor;

import java.util.Optional;

public interface ActorDao {
    void insertActor(Actor actor);
    Optional<Actor> findActorByName(String actor);

}
