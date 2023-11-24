package com.example.springbootjdbc.movie;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("moviename"),
                LocalDate.parse(resultSet.getString("releaseDate")));    }
}
