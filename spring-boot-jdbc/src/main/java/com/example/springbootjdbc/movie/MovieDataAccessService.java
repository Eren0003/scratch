package com.example.springbootjdbc.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Movie> selectMovies() {
        String sql = """
                SELECT id , moviename , releasedate  FROM movie;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        String sql = """
                SELECT id,moviename,releasedate FROM movie WHERE id = ?
                """;
        return jdbcTemplate.query(sql,new MovieRowMapper(),id).stream().findFirst();
    }
    @Override
    public int insertMovie(MovieDto movie) {
        String sql = """
                INSERT INTO movie(id ,moviename, releasedate)
                VALUES(?,?,?);
                """;
        return jdbcTemplate.update(sql,movie.id,movie.moviename,movie.releaseDate);
    }

    @Override
    public void deleteMovie(int id) {
        String sql = """
                DELETE FROM movie WHERE id = ?        
                """;
         jdbcTemplate.update(sql,id);
    }

    @Override
    public Optional<Movie> selectMovieByName(String moviename) {
        String sql = """
                SELECT id , moviename , releasedate FROM movie 
                WHERE moviename = ?
                """;
        return jdbcTemplate.query(sql,new MovieRowMapper(),moviename).stream().findFirst();
    }
}
