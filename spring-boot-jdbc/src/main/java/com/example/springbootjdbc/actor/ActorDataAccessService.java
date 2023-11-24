package com.example.springbootjdbc.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ActorDataAccessService implements ActorDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insertActor(Actor actor) {
        String sql = """
                INSERT INTO actor(actorname) 
                VALUES(?)
                """;
        jdbcTemplate.update(sql,actor.getActorname());
    }

    @Override
    public Optional<Actor> findActorByName(String actor) {
        String sql = """
                SELECT actorname FROM actor 
                WHERE actorname = ?
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper(),actor).stream().findFirst();

    }
}
