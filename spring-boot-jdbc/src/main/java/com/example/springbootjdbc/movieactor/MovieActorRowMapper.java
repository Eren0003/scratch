package com.example.springbootjdbc.movieactor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieActorRowMapper implements RowMapper<MovieActor> {
    @Override
    public MovieActor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new MovieActor(
                resultSet.getInt("movieid"),
                resultSet.getString("actorname"));
    }
}
