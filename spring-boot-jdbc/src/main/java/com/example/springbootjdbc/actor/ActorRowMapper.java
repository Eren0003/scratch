package com.example.springbootjdbc.actor;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorRowMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Actor(resultSet.getString("actorname")
        );
    }
}
